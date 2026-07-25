/*
 * 2025-06-26
 * 문제50_백준 1717번
 * */

package day8.B1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

///* 1차 코드 */
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        for(int i = 0; i < m; i++){
//            st = new StringTokenizer(br.readLine());
//            int zor = Integer.parseInt(st.nextToken()); //zero or one
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//        } // 여기까지 입력받고
//
//        // 여기서 zor이 0이면 union 호출, 1이면  find 호출할 예정.
//
//
//
//    }
//    /***/
//    static void union(int[] a, int[]b){
//        int lenC = a.length + b.length;
//        int[] c = new int[lenC]; // 새로운 배열
//
//        for(int i = 0; i < lenC; i++){
//            Arrays.copy(c, a);
//
//        }
//    }
//
//    /***/
//    static void find(){
//
//    }
//}


/**
 *  union-find code
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i; // 처음엔 자기 자신이 부모
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int zor = Integer.parseInt(st.nextToken()); //zero or one
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 여기까지 입력받고

            if(zor == 0){
                union(parent, a,b);
            }else{
                if (find(parent, a) == find(parent, b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
    /**
     * find 함수. x의 최상위 부모를 찾는 함수
     *
     * @return
     */
    static int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]); // 재귀
        }
        return parent[x];
    }

    /***/
    static void union(int[] parent, int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}