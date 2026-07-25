/*
 * 2025-08-08
 * class2 - 백준 1676번
 * */
package baekjoon.class2.B1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int pack = packfunction(N); // 어떤 수
//        int count = 0;
//
//        System.out.println(pack); // 이게 이상한수나와
//
//        while(pack != 0){
//            if(pack % 10 == 0){
//                count++;
//            }
//            pack = pack / 10;
//        }
//
//        System.out.println(count);
//
//        br.close();
//    }
//    public static int packfunction(int N){
//        int i = 1;
//        int result = 1;
//
//        if(N == 0 || N == 1){
//            return 1;
//        }
//
//        while(i != N + 1){
//            result = result * i++; // result = 1 * 1;, i=2; while i != 3이니까 result = 1 * 2 = 2; i == 3 whlie
//        }
//
//        return result;
//    }
//} // 아 미친 이거 100! 만 가도 long으로도 안됨 ->이렇게 풀면 안돼
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        // 5의 배수 개수만 세면 됨
        while (N >= 5) {
            count += N / 5;
            N /= 5;
        }

        System.out.println(count);
        br.close();
    }
}