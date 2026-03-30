/*
 * 2025-07-29
 * class2 - 백준 15829번
 * */
package baekjoon.class2.B15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] int_array = new int[N];
        char[] char_array = br.readLine().toCharArray();

//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++){
//            char_array[i] = st.nextToken().charAt(i);
//        }

        int answer = 0;

        // 변환
        for(int i = 0; i < N; i++){
            int_array[i] = char_array[i] - 'a' + 1;

            answer = answer + (int_array[i] * cycle(31, i));
        }

        System.out.println(answer);

        br.close();
    }
    public static int cycle(int r, int n){
        int i = 1;
        if(n == 0){
            return 1;
        }else if(n == 1){
            return r;
        }else{
            while(i != n){
                r = r * r;
                i++;
            }
        }
        return r;
    }
}
*/
// mod를 넣어야지
// 그리고 long 써야 함.
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] char_array = br.readLine().toCharArray();

        long answer = 0;
        long mod = 1234567891;

        for (int i = 0; i < N; i++) {
            int val = char_array[i] - 'a' + 1; // 문자 → 숫자 변환
            long pow = cycle(31, i, mod);      // 31^i % mod
            answer = (answer + val * pow) % mod;
        }

        System.out.println(answer);

        br.close();
    }

    // 31^n % mod 를 구하는 함수 (반복 제곱 방식)
    public static long cycle(long r, int n, long mod){
        long result = 1;
        for (int i = 0; i < n; i++) {
            result = (result * r) % mod;
        }
        return result;
    }
}

