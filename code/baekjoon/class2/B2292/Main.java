/*
 * 2025-07-28
 * class2 - 백준 2292번
 * */
package baekjoon.class2.B2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int rslt = hexa(N);
        System.out.println(rslt);

        br.close();
    }
    public static int hexa(int N){
        int end = 0;
        int start = 1;
        int count = 2;
        int d1 = 1;
        int d2 = 2;
        if(N == 1){
            return 1;
        }
        while(true){
            if(6 * end + 2 <= N && N<= 6 * start + 1){
                return count;
            }else{
                count++;
                end = end + d1++;
                start = start + d2++;
            }
        }
    }
}

// 1
// 1 + 1 ~ 1+6 -> 2 (2부터 7까지) 6 * 0 + 2 ~ 6 * 1 + 1
// 1+6 +1 ~ ((1+6)+12) -> 3 (8부터 19까지) 6 * 1 + 2 부터 6 * 3 + 1
// ((1+6)+12) + 1 ~ ((1+6)+12) + 18-> 4 //  6 * 3 + 2부터 6 * 6 + 1
// 38 부터 61까지 6 * 10 + 1 // 6 * 6 + 2부터 6 * 10 + 1
// 0 1 3 6 10 15 21 ~ (1 3 6 10 똑같이 따라감 대신 하나 앞서서)

