/**
 *  2025-03-10
 *  문제010_백준 11003번
 * */
package day3.B11003;

import java.util.Scanner;

public class Main {
    static int N;
    static int L;
    static int[] array;
    static int[] partArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 전체 수열의 길이
        L = sc.nextInt(); // 최솟값을 구하는 범위
        array = new int[N];
        partArray = new int[L];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }

        // 초기 윈도우 설정
        for(int i = 0; i < L && i < N; i++){
            addInt(i);
        }
        System.out.print(findMin() + " ");

        // 슬라이딩 윈도우
        for(int i = L; i < N; i++){
            addInt(i);
            System.out.print(findMin() + " ");
        }
        sc.close();
    }

    static void addInt(int i){
        partArray[i % L] = array[i];
    }
    static int findMin(){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < L; i++){
            min = Math.min(min, partArray[i]);
        }
        return min;
    }
}
