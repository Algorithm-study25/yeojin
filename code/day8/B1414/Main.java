/*
 * 2025-08-07
 * 문제066_백준 1414번
 */
package day8.B1414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;
        parent[py] = px;
        return true;
    }

    static int convert(char ch) {
        if (ch == '0') return 0;
        if ('a' <= ch && ch <= 'z') return ch - 'a' + 1;
        return ch - 'A' + 27;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Edge> edges = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                int weight = convert(line.charAt(j));
                total += weight;
                if (i != j && weight > 0) {
                    edges.add(new Edge(i, j, weight));
                }
            }
        }

        Collections.sort(edges);
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        int mst = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                mst += edge.weight;
                count++;
                if (count == N - 1) break;
            }
        }

        if (count == N - 1) {
            System.out.println(total - mst);
        } else {
            System.out.println(-1);
        }
    }
}
