import java.util.*;

public class outoever2 {
    public int solution(int n, int[][] networks, int[][] server_pair) {
        Map<String, Integer> maxG = new HashMap<>();
        Map<String, Integer> minG = new HashMap<>();

        for (int[] net : networks) {
            int u = Math.min(net[0], net[1]);
            int v = Math.max(net[0], net[1]);
            int cost = net[2];

            String key = u + "-" + v; // [수정 1] 변수 값 결합

            maxG.put(key, Math.max(maxG.getOrDefault(key, Integer.MIN_VALUE), cost));
            minG.put(key, Math.min(minG.getOrDefault(key, Integer.MAX_VALUE), cost));
        }

        // [수정 4] 최소, 최대 각각 구하기
        int minCost = solve(n, networks, server_pair, minG, true);
        int maxCost = solve(n, networks, server_pair, maxG, false);

        return minCost; // 문제 조건에 맞춰 반환 (예: maxCost - minCost 등)
    }

    static int[] parent;

    private int solve(int n, int[][] networks, int[][] server_pair, Map<String, Integer> map, boolean isMin) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int total_cost = 0;

        // 1. 필수 연결 정점(server_pair) 우선 처리
        for (int[] pair : server_pair) {
            int u = Math.min(pair[0], pair[1]);
            int v = Math.max(pair[0], pair[1]);
            String key = u + "-" + v; // [수정 1]

            if (map.containsKey(key)) {
                if (union(u, v)) {
                    total_cost += map.get(key); // [수정 2] 누적합
                }
            }
        }

        // 2. Map에서 정제된 간선들만 추출하여 리스트로 구성 [수정 3]
        List<int[]> edges = new ArrayList<>();
        for (String key : map.keySet()) {
            String[] parts = key.split("-");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int cost = map.get(key);
            edges.add(new int[]{u, v, cost});
        }

        // 3. 정렬
        if (isMin) {
            edges.sort((a, b) -> Integer.compare(a[2], b[2]));
        } else {
            edges.sort((a, b) -> Integer.compare(b[2], a[2]));
        }

        // 4. 크루스칼 적용
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (union(u, v)) {
                total_cost += cost;
            }
        }

        return total_cost;
    }

    static boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootU] = rootV;
            return true;
        }
        return false;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}