/*
 * 2025-07-24
 * 문제046_백준 1219번
 * */
package day8.B1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited; // for dfs
    static boolean startToEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max[] = new int[N];

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            max[i] = Integer.parseInt(st.nextToken());
        }

        long dist[] = new long[N];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[start] = max[start];

        List<Integer> cycleNodes = new ArrayList<>();

        // 벨만 포드 n-1번
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[j] == Long.MIN_VALUE) continue;
                for (Edge edge : graph.get(j)) {
                    int to = edge.to;
                    long weight = -edge.weight + max[to];

                    if (dist[to] < dist[j] + weight) {
                        dist[to] = dist[j] + weight;
                    }
                }
            }
        }

        // N번째 → 사이클 후보 저장
        for (int j = 0; j < N; j++) {
            if (dist[j] == Long.MIN_VALUE) continue;
            for (Edge edge : graph.get(j)) {
                int to = edge.to;
                long weight = -edge.weight + max[to];

                if (dist[to] < dist[j] + weight) {
                    cycleNodes.add(j); // 사이클 후보 노드
                }
            }
        }

        // 사이클 후보 중 end에 도달 가능한 노드가 있는지확인해야함.
        visited = new boolean[N];
        for (int node : cycleNodes) {
            Arrays.fill(visited, false);
            dfs(node, end, graph);
            if (startToEnd) {
                break;
            }
        }

        if (startToEnd) {
            System.out.println("Gee");
        } else if (dist[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(dist[end]);
        }

        br.close();
    }

    public static void dfs(int current, int end, List<List<Edge>> graph) {
        if (current == end) {
            startToEnd = true;
            return;
        }

        visited[current] = true;

        for (Edge edge : graph.get(current)) {
            int next = edge.to;
            if (!visited[next]) {
                dfs(next, end, graph);
            }
        }
    }
}
