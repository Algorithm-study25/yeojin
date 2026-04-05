/*
 * 2025-07-01
 * 문제049-백준 2251 물통
 * */

package day8.B2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] bucket;
    public static int A;
    public static int B;
    public static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine()); // 8
        B = Integer.parseInt(br.readLine()); // 9
        C = Integer.parseInt(br.readLine());

        //int leftoverA = 0;
        //int leftoverB = 0;
        //int leftoverC = C; // 초기값 셋팅

        //calc(leftoverA, leftoverB, leftoverC);

        bucket = new int[3];
        bucket[0] = 0;
        bucket[1] = 0;
        bucket[2] = C;

        calc(bucket[0], bucket[1], bucket[2]);

        br.close();
    }
    public static void calc(int to, int mid, int from){ // from -> to로 가는 것.
        if(to > from){
            bucket[from] = 0;
            bucket[to] = ;
        }else if(to < from){
            bucket[to] = to;
            bucket[from] = from - to;
        } {
            if(bucket[to] + bucket[from] > bucket[to]){ // 버킷의 최대 허용 크기 그니까 A,B,C
                bucket[to] = bucket[to] +  // 버킷의 최대 허용 크기 - (옮기ㅡㄴㄴ거)
                bucket[from] = bucket[from] + ;
            }else{
                bucket[to] = bucket[to] + bucket[from];
                bucket[from] = 0;
            }

        }
    }
}
***/
/*
* (1)- dfs 풀이
* */
public class Main{
    static int A, B, C;
    static boolean[] result = new boolean[201];
    static boolean[][][] visited = new boolean[201][201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0, 0, C);

        for (int i = 0; i <= 200; i++) {
            if (result[i]) {
                System.out.print(i + " ");
            } // 여기서 true인것만 출력하는 것.
        }
    }

    public static void dfs(int a, int b, int c){

        /**
         * [ 기저 조건 ]
         * visited 배열에 대한 기저 조건
         * */
        if(visited[a][b][c]){
            return; // 기저 조건
        }
        visited[a][b][c] = true;

        // 이 조건을 빼먹으면 안돼. 왜?
        if (a == 0) {
            result[c] = true;
        }

        /**
         * [ 결과 처리 ]
         * from -> to로 옮기기
         * 결국엔 6가지 경우 밖에 없으니까 6가지 경우를 다 호출했어야 함.
         * */
        pour(a, b, c, 0, 1); // A->B
        pour(a, b, c, 0, 2); // A->C
        pour(a, b, c, 1, 0); // B->A
        pour(a, b, c, 1, 2); // B->C
        pour(a, b, c, 2, 0); // C->A
        pour(a, b, c, 2, 1); // C->B
    }

    public static void pour(int a, int b, int c, int from, int to){
        int[] arr = {a, b, c}; // 현재 각 물통의 물의 양
        int[] limit = {A, B, C}; // 전체 부피

        /**
         * from 쪽에 물이 부족하면 그만큼만 붓고
         * to 쪽 공간이 부족하면 꽉 찰 때까지만 붓고
        */
        int amount = Math.min(arr[from], limit[to] - arr[to]);

        arr[from] = arr[from] - amount;
        arr[to] = arr[to] + amount;


        /**
         * [ 재귀 호출 ]
         * 바뀐 상태로 dfs를 재귀 호출해야함.
         * */
        dfs(arr[0], arr[1], arr[2]);
    }
}

//
///**
// * (2) - bfs로 푼 경우
// * */
//public class Main{
//    static int A, B, C;
//    static boolean[] result = new boolean[201];
//    static boolean[][][] visited = new boolean[201][201][201];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        A = Integer.parseInt(st.nextToken());
//        B = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        bfs();
//
//        for (int i = 0; i <= 200; i++) {
//            if (result[i]){
//                System.out.print(i + " ");
//            }
//        }
//    }
//
//    public static void bfs(){
//        Queue<State> queue = new LinkedList<>();
//        queue.offer(new State(0, 0, C));
//        visited[0][0][C] = true;
//
//        while(!queue.isEmpty()){
//            State now = queue.poll(); // int now = queue.poll() 하면 왜 오류나?
//            // 답 : queue에 들어있는 자료형이 state이기 때문.
//
//            // a==0일때 c의 경우의 수. result 배열이 true인 경우
//            if(now.a == 0){
//                result[now.c] = true;
//            }
//
//            // 여기서는 이제 로직
//            int[] curr = {now.a, now.b, now.c}; // 현재 들어있는 값
//            int[] limit = {A, B, C};
//
//            for (int from = 0; from < 3; from++) {
//                for (int to = 0; to < 3; to++) {
//                    if (from == to) continue;
//
//                    int[] next = Arrays.copyOf(curr, 3); // 현재 상태 복사, 물 옮기고 난 후 다음 상태를 저장하기 위함.
//                    /**
//                     * 6가지 경우를 다 돈다.
//                     * 자기자신에게 붓는 경우를 제외하기 위해서 to == from 일 때 continue 하는 거임.
//                     * */
//                    int amount = Math.min(next[from], limit[to] - next[to]); //
//
//                    next[from] -= amount;
//                    next[to] += amount;
//
//                    /**
//                     * 이미 탐색했던 상태는 큐에 다시 넣지 않고
//                     * 새로운 상태만 큐에 넣는다.
//                     * 중복 탐색 방지 + 무한 루프 방지
//                     * */
//                    if (!visited[next[0]][next[1]][next[2]]) {
//                        visited[next[0]][next[1]][next[2]] = true;
//                        queue.offer(new State(next[0], next[1], next[2]));
//                    }
//                }
//            }
//
//        }
//
//    }
//
//    static class State{
//        int a, b, c;
//        public State(int a, int b, int c){
//            this.a = a;
//            this.b = b;
//            this.c = c;
//        }
//    }
//}
//
///**
// *
// * (3) - bfs 쓰되, state 안쓰고 int[] 쓰는 방법
// * */
//
//
//public class Main {
//    static int A, B, C;
//    static boolean[][][] visited = new boolean[201][201][201];
//    static boolean[] result = new boolean[201];
//
//    public static void bfs() {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{0, 0, C});
//        visited[0][0][C] = true;
//
//        while (!queue.isEmpty()) {
//            int[] curr = queue.poll();
//            int a = curr[0], b = curr[1], c = curr[2];
//
//            if (a == 0) result[c] = true;
//
//            int[] amount = {a, b, c};
//            int[] limit = {A, B, C};
//
//            // 물 옮기기: from → to
//            for (int from = 0; from < 3; from++) {
//                for (int to = 0; to < 3; to++) {
//                    if (from == to) continue;
//
//                    int[] next = Arrays.copyOf(amount, 3);
//
//                    int pourAmount = Math.min(next[from], limit[to] - next[to]);
//                    next[from] -= pourAmount;
//                    next[to] += pourAmount;
//
//                    if (!visited[next[0]][next[1]][next[2]]) {
//                        visited[next[0]][next[1]][next[2]] = true;
//                        queue.offer(next); // int[] 상태 그대로 큐에 넣기
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        A = Integer.parseInt(st.nextToken());
//        B = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        bfs();
//
//        for (int i = 0; i <= 200; i++) {
//            if (result[i]) System.out.print(i + " ");
//        }
//    }
//}
