package day5.B2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 두 값 입력받고
        int[] a = new int[N];

        st = new StringTokenizer(br.readLine()); // 줄바꿈 하고
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        } // 배열까지 입력받음

        // 이미 다 정렬되어있음.
        //


    }
}
