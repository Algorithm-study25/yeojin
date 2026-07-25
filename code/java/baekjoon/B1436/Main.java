/*
 * 2025-08-08
 * class2 - 백준 1436번
 * */
package baekjoon.class2.B1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int count = 0;
        int num = 666;

        while(true){
            if(String.valueOf(num).contains("666")){
                count++;
            }
            if(count == (Integer.parseInt(N))){
                System.out.println(num);
                break;
            }
            num++;
        }

        br.close();
    } // 무한루프코드
}
