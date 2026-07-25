/*
 * 2025-07-02
 * 문제51_백준 1976번
 * */

package day8.B1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] array;
    public static int[] plan;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        array = new int[N + 1][N + 1];
        parent = new int[N + 1];
        plan = new int[M];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        /*
        for(int i = 0; i < N; i++){
            for(int j = 0; j < half; j++){
                st = new StringTokenizer(br.readLine());
                array[i][j] = Integer.parseInt(st.nextToken());
            }
            half++;
        } // 반만 입력받기(삼각형)
        */
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        // 여기서 핵심 로직
        int root = find(plan[0]); // 첫 도시의 루트
        boolean possible = true;

        for(int i = 1; i < M; i++){
            if(find(plan[i]) != root){ //다른 도시의 루트가 첫 루트랑 다르면 -> 연결되어 있지 않음!!!
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");

        br.close();
    }
    /**
     * find 함수
     * */
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * union 함수
     * */
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}
