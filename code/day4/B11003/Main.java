/**
 * 2025-03-21 백준 11003번
 * */
package day4.B11003;

import java.util.Scanner;

public class Main {
    /*
    D1 = A1-3+1 = A-1 ~ A1까지의 최솟값이니까 A1 = 1
    D2 = A2-3+1 = A0부터 A2까지의 최솟값 = A1 = 1
    D3 = A3-3+1 = A1부터 A3까지의 최솟값 = A1 = 1
    D4 = A2부터 A4까지의 최솟값 = A3= 2
    슬라이딩 윈도우?
    */

    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] A = new int[N];

        int[] D = new int[L];
        // 슬라이딩 윈도우에서는 고정 배열 쓰면 안돼.

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            if(i - L + 1 <= 0){
                // 넘어가라
                continue;
            }else {
                for (int j = i; j < i - L + 1; j++) {
                    int min = D[i];
                    D[j] = Math.min(min, D[j]);
                    A[i] = D[j];
                }
            }System.out.print(A[i] + " "); // 여기서 에러
        }
        sc.close();
    }
}
