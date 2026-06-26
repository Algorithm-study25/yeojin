/*
 * 2025-07-04
 * class2 - 백준 30802번
 * */

package baekjoon.class2.B30802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 전체 인원수

        int[] size = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <6; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int countForT = 0;

        for(int i = 0; i < 6; i++){
            countForT += (size[i] + T -1) / T;
        } // 여기가 핵심

        int countForP = 0;
        int leftoverForP = 0;

        countForP = N / P;
        leftoverForP = N % P;

        System.out.println(countForT);
        System.out.println(countForP + " " + leftoverForP);

        br.close();
    }
}
