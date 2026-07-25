package day4.B11003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = Math.max(0, i - L + 1); j <= i; j++) {
                min = Math.min(min, A[j]);
            }
            System.out.print(min + " ");
        }
        sc.close();
    }
}