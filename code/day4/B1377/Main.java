/**
 *  2025-03-21
 *  문제016_백준 1377번 (다시풀기)
 * */
package day4.B1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 입력받기

        mData[] mdata = new mData[N];

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            mdata[i] = new mData(value, i);
        }

        Arrays.sort(mdata);

        int max = Integer.MIN_VALUE;

        for(int j = 0; j < N; j++){
            if(max < mdata[j].index - j){
                max = mdata[j].index - j;
            }
        }

        System.out.println(max + 1);
    }
}
