/*
 * 2025-07-25
 * 문제56_백준 1854
 * */
package day8.B1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static PriorityQueue<Integer>[] pq; // 각 정점 최단 거리 저장하기 위해서
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int k = Integer.parseInt(st.nextToken()); // k번째 최단거리

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        // 각 노드마다 k개의 최단 거리 저장용 최대 힙
        PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        dist[1].add(0);

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.to;
            int cost = current.weight;

            for (Edge next : graph.get(now)) {
                int nextNode = next.to;
                int nextCost = cost + next.weight;

                if (dist[nextNode].size() < k) {
                    dist[nextNode].add(nextCost);
                    pq.offer(new Edge(nextNode, nextCost));
                } else if (dist[nextNode].peek() > nextCost) {
                    dist[nextNode].poll();
                    dist[nextNode].add(nextCost);
                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() < k) {
                sb.append("-1\n");
            } else {
                sb.append(dist[i].peek()).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}
