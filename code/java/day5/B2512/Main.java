// 2512번 백준
package day5.B2512;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a[] = new int[N];
        int sum = 0;

        for(int i  = 0; i < N; i++){
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){

        }
    }
}
