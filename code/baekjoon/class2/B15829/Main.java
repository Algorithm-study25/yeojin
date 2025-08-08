/*
 * 2025-07-29
 * class2 - 백준 15829번
 * */
package baekjoon.class2.B15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }
}
