/*
 * 2025-07-29
 * class2 - 백준 2798번
 * */
package baekjoon.class2.B2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] card = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        // 이렇게 무식하게 말고 다른 좋은 방법?
//        int closeToM = 0;
//
//        for(int i = 0; i < N - 2; i++){
//            for(int j = i + 1; j < N - 1; j++){
//                for(int k = j + 1; k < N; k++){
//
//                    if(card[i] + card[j] + card[k] - M < 0 && card[i] + card[j] + card[k] - M > closeToM - M){
//                        closeToM = card[i] + card[j] + card[k];
//                    }else if(card[i] + card[j] + card[k] - M < closeToM - M || card[i] + card[j] + card[k] - M > 0){
//                    }else{ // 같은 경우. M과
//                        closeToM = card[i] + card[j] + card[k];
//                        break;
//                    }
//                }
//            }
//        }
//
//        System.out.println(closeToM);

// 아 이거 어쩔수없이 삼중 for문이 필요하긴하네..

        System.out.println(search(card,N,M));

        br.close();
    }
    public static int search(int[] card, int N, int M){
        int result = 0;
        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++) {
                    int temp = card[i] + card[j] + card[k];
                    if(temp == M) // M과 같으면 temp 리턴
                        return temp;

                    if(result < temp && temp < M) // 더한 값이 result보다 크고 M보다 작으면
                        result = temp; // 여기가 나랑 달라. 아 그냥 간단하게.. 맞네...
                }

            }
        } return result;

    }
}
/**
 * 카드의 합이 M을 넘지 않는 한도 내에서 카드의 합이 최대,M과 가장 가깝게
 * 3장의 합
 * 5, 21
 * 5 6 7 8 9 -> 9 7 5
 * */


