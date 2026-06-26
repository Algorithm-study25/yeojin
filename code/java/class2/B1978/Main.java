/*
 * 2025-07-26
 * class2 - 백준 2018번
 * */
package baekjoon.class2.B1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] array = new int[N];
//
//        for(int i = 0; i < N; i++){
//            array[i] = Integer.parseInt(st.nextToken());
//        } 굳이 배열로 둘 필요 없고 받으면서 동시에 isPrime 계산하면 됨.

        // 소수의 갯수인데, 소수란? 자기자신과 1 제외 약수가 없는
        int count = 0;


        System.out.println(count);

        br.close();
    }
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++){ // 여기서 n까지 돌리는 게 아니라 n의제곱근까지만 돌림
            // 소수 판별할 때 어떤 수 n이 소수가 아닌 경우, n을 나누는 약수 중 하나는 반드시 √n 이하에 있어. -> 왜지.
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
