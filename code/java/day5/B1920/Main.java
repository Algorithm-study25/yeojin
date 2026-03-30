/**
 *  2025-05.08.
 *  문제029 백준 1920번
 * */
package day5.B1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        A = new int[n];

        st = new StringTokenizer(br.readLine()); // 줄 바꿈 하고싶을때마다
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        } // 원본 데이터 입력받기

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // m 은 찾아야 할 숫자 갯수를 의미한다.
        int newA[] = new int[m]; // newA는 찾아야 할 숫자의 배열을 의미한다.

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            newA[i] = Integer.parseInt(st.nextToken());
        } // 여기까지가 입력 부분

        // 1. 원본 데이터 정렬
        Arrays.sort(A);

        // 2. 이진탐색으로 newA의 배열 하나씩 확인
        StringBuilder sb = new StringBuilder(); // System.out.println() 매번 쓰면 너무 느려.
        for (int i = 0; i < m; i++) {
            if (bs(0, n - 1, newA[i])) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean bs(int start, int end, int target){
        while(start <= end){
            int middle = (start + end) / 2;

            if(A[middle] == target){
                return true;
            }else if(A[middle] < target){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        return false;
    }
}

