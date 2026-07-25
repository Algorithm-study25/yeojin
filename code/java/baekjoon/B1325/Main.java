/*
 * 2025-06-26
 * 문제046_백준 1325번
 * */

package day8.B1325;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
public class Main {
    static List<ArrayList<Integer>> list;
    static int ans[];
    static int n, m;
    static boolean visit[];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[n+1];


        list = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        //이 값이 최대인 경우의 노드를 해킹하면 최댓값만큼의 컴퓨터를 해킹가능
        //각 노드에서 출발했을때, 최대의 경우의수를 구해야한다.
        //방향이 있는 그래프이기 때문에 사이클을 이루지 않는다면, 특정 노드를 출발노드로 잡았을때, 탐색을 아에 하지 않는 경우가 존재할 수 있다.
        //따라서 모든 노드를 출발점으로 잡아서 탐색을 진행해야 한다.
        for(int i=1; i<=n;i++) {
            visit = new boolean[n+1];
            BFS(i);
        }

        int max = Integer.MIN_VALUE;

        //최댓값 찾기
        for(int i=1; i<=n;i++) {
            max = Math.max(max, ans[i]);
        }

        for(int i=1; i <=n ; i++) {
            if(ans[i]==max) {
                System.out.print(i + " ");
            }
        }


    }
    private static void BFS(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        visit[i] = true;
        q.add(i);

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int a : list.get(now)) {
                if(!visit[a]) {
                    visit[a] =true;
                    //현재 노드 now에서 a노드로 이동할 수 있다는 것은
                    //now가 a를 신뢰한다는 뜻이다.
                    ans[a]++;
                    q.add(a);
                }
            }
        }
    }

}

/*
    A가 B를 신뢰한다. -> A가 B를 방문한다.
    가장 많은 컴퓨터를 해킹하기 위해서 가장 많은 노드에게 신뢰받는 노드를 찾아야 한다.
    즉, 가장 많은 노드에게 연결당하는 노드를 찾는다.
    A가 B를 신뢰하는데, B가 C를 신뢰한다고 가정해보자. C를 해킹하면 C를 신뢰하는 A, B 모두 해킹할 수 있다.

public class Main {

    static final int N = 10001;
    static int max = 0;

    static List<Integer>[] list = new ArrayList[N];
    static List<Integer> result = new ArrayList<>();
    static boolean[] visit = new boolean[N];
    static int[] connect = new int[N];

    static void DFS(int current){

        visit[current] = true;

        for(int next : list[current])
            if(!visit[next]) {
                connect[next]++;
                DFS(next);
            }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());

            int home = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            list[home].add(target);
        }

        for(int i=1; i<=n; i++) {
            visit = new boolean[N];
            DFS(i);
        }

        for(int i=1; i<=n; i++)
            if (connect[i] > max) {
                max = connect[i];
                result.clear();
                result.add(i);
            } else if (connect[i] == max)
                result.add(i);

        for(int a:result)
            System.out.print(a + " ");
    }
}
*/
// 미제. 왜 안돌아갈까?
import java.io.*;
        import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited; // boolean → int
    static int ans = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n + 1]; // visited 배열 1번만 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a); // b를 해킹하면 a도 가능
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        System.out.println(sb);
    }

    static void bfs(int num) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        visited[num] = num; // 현재 탐색 번호로 마킹
        int cnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            // for-each vs for문 성능 차이 거의 없음 (ArrayList라면)
            for (int next : graph.get(now)) {
                if (visited[next] != num) { // 이번 탐색에서 아직 방문 안 했으면
                    visited[next] = num;
                    cnt++;
                    q.add(next);
                }
            }
        }

        if (ans < cnt) {
            sb = new StringBuilder();
            sb.append(num).append(" ");
            ans = cnt;
        } else if (ans == cnt) {
            sb.append(num).append(" ");
        }
    }
}
