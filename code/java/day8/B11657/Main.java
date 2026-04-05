/*
 * 2025-07-25
 * 문제59 -백준 11657 줄 세우기
 * */
package day8.B11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        int start = 1;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }

        long dist[] = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // n-1번 돌면서 벨만 포드 조건 확인
        for(int i = 1; i <= N-1; i++){
            for(int j = 1; j <= N; j++){
                for(Edge edge : graph.get(j)){
                    int to = edge.to;
                    int weight = edge.weight;

                    if(dist[j] != Integer.MAX_VALUE && dist[to] > dist[j] + weight){
                        dist[to] = dist[j] + weight;
                    }
                }
            }
        }
        boolean cycle = false;

        // 마지막 n번째거는 음수를 확인한다.
        for(int i = 1; i <= N; i++){
            for(Edge edge : graph.get(i)){
                int to = edge.to;
                int weight = edge.weight;

                if(dist[i] != Integer.MAX_VALUE && dist[to] > dist[i] + weight){
                    cycle=true;
                    break;
                }
            }
        }

        if(cycle){
            System.out.println("-1");
        }else{
//            for(int i = 2; i<= N; i++){
//                if(dist[i] == Integer.MAX_VALUE){
//                    System.out.println("-1");
//                }else{
//                    System.out.println(dist[i]);
//                }
//            }
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.print(sb);
        }

        br.close();
    }
}
