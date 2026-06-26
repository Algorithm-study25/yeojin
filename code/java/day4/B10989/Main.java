package day4.B10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            int[] count = new int[10001];

            // 숫자 빈도
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                count[num]++;
            }

            // 출력.
            for (int i = 1; i < 10001; i++) {
                while (count[i] > 0) {
                    sb.append(i).append("\n");
                    count[i]--;
                }
            }

            System.out.print(sb);
        }
}
*/

public class Main{
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        int[] resultArray = new int[N];
        int[] nujukhap = new int[N + 1];
        nujukhap[0] = 0;

        for(int i =0; i < N; i++){
            int E = Integer.parseInt(br.readLine());
            array[i] = E;
            nujukhap[E]++;
        }

        for(int i =1; i < nujukhap.length; i++){
            nujukhap[i] += nujukhap[i-1];
        }

        for(int i = N - 1; i >= 0; i--){
            int idx = array[i];
            resultArray[nujukhap[idx] - 1] = idx;
            nujukhap[idx]--;
        }

        for(int temp : resultArray) {
            System.out.println(temp);
        }
    }
}