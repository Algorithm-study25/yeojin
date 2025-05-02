/**
 *  2025-03-20
 *  문제010_백준 1427번
 * */
package day4.B1427;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        */
        String s = br.readLine();
        int[] a = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '\0';
            // a[i] = Integer.parseInt(s.substring(i));
        } // a[i] = (int)(s.substring(i)) 안돼
        // 아 s.substring(i) : 문자열의 i번째 문자부터 끝까지 반환함
        // s.substring(1) = "143"

        Arrays.sort(a);

        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(a[i]);
        }

    }
}
