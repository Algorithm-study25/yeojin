package day6.B1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] MV = new int[N][2];
        int[] C = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            MV[i][0] = Integer.parseInt(st.nextToken());
            MV[i][1] = Integer.parseInt(st.nextToken());
        } // 이렇게 입력을 아예 받고(2차원배열로)

        for(int i = 0; i < K; i++){
            C[i] = Integer.parseInt(br.readLine());
        } // 여기까지 입력받고

        Arrays.sort(MV, (a, b) -> a[0] - b[0]); // 무게 기준 오름차순으로 해야 해.
        // 우리는 가치 기준으로 뽑는 거는 맞긴 한데, 일단 무게가 통과되고, ㄱ 중에서 가장 큰 가치를 return하면 되니까.

        Arrays.sort(C);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0; // 보석 인덱스
        long total = 0; // 가치 계산(구하는 것)

        for (int i = 0; i < K; i++) {
            int capacity = C[i];

            // 현재 가방에 담을 수 있는 보석들을 큐에 넣어.
            while (j < N && MV[j][0] <= capacity) {
                pq.add(MV[j][1]); // 가치만 저장
                j++;
            }

            // 큐에서 가장 비싼 보석을 빼야 해.
            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}
