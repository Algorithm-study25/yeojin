package day5.B7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int L = Integer.parseInt(br.readLine()); // 체스판 크기
            int[][] dist = new int[L][L];
            boolean[][] visited = new boolean[L][L];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int answer = bfs(startX, startY, endX, endY, L, visited, dist);
            System.out.println(answer);
        }
    }

    public static int bfs(int sx, int sy, int ex, int ey, int L, boolean[][] visited, int[][] dist) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        dist[sx][sy] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x == ex && y == ey) return dist[x][y];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < L && ny < L && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return 0; // 시작과 도착이 같은 경우
    }
}
