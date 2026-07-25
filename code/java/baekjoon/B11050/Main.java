package day10.B11050;

import java.io.*;
import java.util.*;

//public class Main {
//    static int fact(int x) {
//        int r = 1;
//        for (int i = 2; i <= x; i++) {
//            r *= i;
//        }
//        return r;
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int ans = fact(n) / (fact(k) * fact(n - k));
//        System.out.println(ans);
//    }
//}

// 두번째 방법 -교재 설명, dp 써서 배열로 풀기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        // 초기값 세팅
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // nC0 = 1
            if (i <= k) {
                dp[i][i] = 1; // nCn = 1
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
