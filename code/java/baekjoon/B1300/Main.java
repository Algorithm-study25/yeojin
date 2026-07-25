package day5.B1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 값 입력받고
        int[][] a = new int[n][n];

        // 1. 정렬해야하는데 arrays.sort가 이차원도 되나? -> 안되네. 그러면.. 이차원 -> 일차원으로 만들고, 배열 b를 sort하자.
        //


    }
}
