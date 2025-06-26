/*
 * 2025-06-26
 * 문제046_백준 18352번
 * */
package day8.B18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int X = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[X] = 0; // 시작 도시는 거리가 0

        Queue<Integer> q = new LinkedList<>();
        q.offer(X);

        while(!q.isEmpty()){
            int current = q.poll();
            for(int next : graph.get(current)){
                if(distance[next] == -1){
                    distance[next] = distance[current] + 1;
                    q.offer(next);
                }
            }
        }

        boolean found = false;

        for(int i = 1; i <= N; i++){
            if(distance[i] == K){
                System.out.println(i);
                found= true;
            }
        }

        if(!found){
            System.out.println(-1);
        }
    }
}
