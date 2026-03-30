/*
 * 2025-07-04
 * class2 - 백준 2018번
 * */

package baekjoon.class2.B2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrays = new int[N];
        int count = 0;
        int sansul = 0; // 산술평균
        int jungang = 0; // 중앙값
        int chaebin = 0; // 최빈값
        int range = 0; // 범위

        for(int i = 0; i < N; i++){
            arrays[i] = Integer.parseInt(br.readLine());
            count += arrays[i];
        }

        // 1. 산술평균 계산
        // sansul = count / N; // 여기도 반올림.. 지금 이렇게 하면 그냥 내림. 이 돼
        sansul = (int)(Math.round((float) count / N));

        // 2. 중앙값 계산
        Arrays.sort(arrays);
        jungang = arrays[N/2];

        // 3. 최빈값 계산
        int[] countArr = new int[8001];
        // -4000 ~ 4000 까지니까 총 8001의 크기

        // counting
        for(int i = 0; i < N; i++){
            countArr[arrays[i] + 4000]++; // 인덱스 보정 필수
        }

        // 최대 빈도 찾기
        int maxFreq = 0;
        for(int freq : countArr){
            if(freq > maxFreq){
                maxFreq = freq;
            }
        }

        // 최대 빈도 가진 값들 수집
        List<Integer> modeList = new ArrayList<>();
        for(int i = 0; i < countArr.length; i++){
            if(countArr[i] == maxFreq){
                modeList.add(i - 4000); // 다시 원래 값으로 보정
            }
        }

        // 최빈값 결정
        int mode;
        if(modeList.size()==1){ // 최대 빈도 가진 값이 하나면,
            mode = modeList.get(0);
        }else{ // 2개 이상이면
            Collections.sort(modeList);
            mode = modeList.get(1);
        }


        // 4. 범위 계산
        range = arrays[N - 1] - arrays[0];

        // 출력
        System.out.println(sansul);
        System.out.println(jungang);
        System.out.println(mode);
        System.out.println(range);

        br.close();
    }
}
