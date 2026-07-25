package day6.B1931;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = Integer.parseInt(br.readLine());
        } // 입력받고.

        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0]; // 첫번째 숫자 기준으로 오름차순.
            }else{
                return a[1] - b[1];
            }
        });

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= endTime) {
                count++;
                endTime = arr[i][1];
            }
        }

        System.out.println(count);
    }
}
