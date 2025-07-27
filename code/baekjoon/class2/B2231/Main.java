/*
 * 2025-07-27
 * class2 - 백준 2231번
 * */
package baekjoon.class2.B2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 216
        int result = 0;

        for(int i = 0; i < N; i++){ // i 가 1부터 216까지
            int sum = 0;
            int number = i;

            while(i != 0){
                sum = sum + i % 10; // sum = 0 + 1
                number = number / 10; // num = 0;
            }

            if(sum + i == N){ // 1 + 원래수 i == N
                result = i;
                break;
            }

        }

        System.out.println(result);

        br.readLine();
    }
}
/*
216 = 1 + 9 + 8 + 198 = n + n/100 + n/10 + n%100
198, 207도 가능
207 = 207 + 2 + 0 + 7
*/
