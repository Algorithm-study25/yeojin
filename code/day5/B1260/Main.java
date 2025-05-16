package day5.B1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];


        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        } // 간선 입력

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        // dfs
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // bfs
        visited = new boolean[N + 1];
        bfs(V);

    }
    public static void dfs(int V){
        visited[V] = true;
        System.out.print(V + " ");

        for(int next : list[V]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v + " ");
            for(int next : list[v]) {
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}

 */
/*
public class Main {

    public static void main(String[] args) throws IOException {
        // 방문할 수 있는 노드가 여러개라면, 노드 번호가 작은 걸 먼저 방문해라
        // 더 이상 방문할 수 있는 노드가 없다면, 종료해라.
        // 노드 번호는 1부터 N 까지다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for()
    }
}
*/
