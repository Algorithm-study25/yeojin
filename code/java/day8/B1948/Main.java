/*
 * 2025-07-11
 * 문제55_백준 1948번
 * */

package day8.B1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] rslt = new int[N + 1]; // start부터 i까지 도달하는데 걸리는 최장 시간

        int[] array = new int[N + 1];// 위상 정렬용 진입 차수 배열

        // List<List<Integer>> list = new ArrayList<>(); // 수정
        List<List<Edge>> list = new ArrayList<>();

        // 누가 누구에게 영향을 줬는지를 역방향으로 저장하는,
        // 최장 시간 end에 도달햇을 때, 어떤 간선이 실제로 최장 경로를 구성하는데 쓰였는지 역으로 추적하기 위함.
        List<List<Integer>> reverse = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.get(node1).add(new Edge(node2, time));

            array[node2]++;
        } // 여기서 time을 어디다 어떻게 저장할건지? -> Edge class를 하나 만들어서 해결함.

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int current = queue.poll();

            // 여기가 핵심 로직
            for(Edge edge : list.get(current)){
                int next = edge.to;
                int time = edge.time;

                if(rslt[next] < rslt[current] + time){
                    rslt[next] = rslt[current] + time;

                    // 역추적 리스트 갱신
                    reverse.get(next).clear();
                    reverse.get(next).add(current);
                }else if(rslt[next] == rslt[current] + time){
                    reverse.get(next).add(current);
                } // 경로가 여러개여도

                array[next]--;
                if (array[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 가장 늦게 도착하는 시간
        System.out.println(rslt[end]);

        // 2. 쉬지 않고 달려야 했던 도로 수 (역추적)
        int count = 0;
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> back = new LinkedList<>();
        back.offer(end);
        visited[end] = true;

        while (!back.isEmpty()) {
            int current = back.poll();

            for (int prev : reverse.get(current)) {
                count++;

                if (!visited[prev]) {
                    visited[prev] = true;
                    back.offer(prev);
                }
            }
        }

        System.out.println(count);


        br.close();
    }
}
