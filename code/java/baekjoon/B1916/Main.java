/*
 * 2025-07-24
 * 문제56_백준 1916번 - 최소비용 구하기
 */

package day8.B1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) { // 1번 도시부터 시작하므로 N+1
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, w));
        }

        // 시작점과 도착점 입력
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(from, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.end;

            if (current.weight > dist[now]) continue;

            for (Edge next : graph.get(now)) {
                if (dist[next.end] > dist[now] + next.weight) {
                    dist[next.end] = dist[now] + next.weight;
                    pq.offer(new Edge(next.end, dist[next.end]));
                }
            }
        }

        System.out.println(dist[to]);
        br.close();
    }
}
