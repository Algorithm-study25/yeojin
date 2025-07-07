/*
 * 2025-07-07
 * 문제052 -백준 2252 줄 세우기
 * */
package day8.B2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N + 1]; // 진입 차수 배열

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        } // 1번부터 N번까지 하기 위해서.
        // 그런데 왜 그럼 i = 1부터 시작하지 않냐? 그 이유는 실수로 graph(0)에 접근했을 때 바로 예외가 터지기 때문에 안정성을 위해

        // 간선 정보 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            indegree[to]++;
        }

        // 위상 정렬 시작
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 추가한다.
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        } // 진입 차수가 0인 노드가 첨부터 없다면 사이클이 있다는 것이고 이는 위상정렬이 될 수 없다.

        StringBuilder sb = new StringBuilder();

        // 위상 정렬 실행
        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current).append(" ");

            for(int next : graph.get(current)){ // graph.get(3) = [1]
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb.toString().trim());

        br.close();
    }
}
