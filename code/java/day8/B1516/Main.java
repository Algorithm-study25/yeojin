/*
 * 2025-07-07
 * 문제052 -백준 1516 게임개발하기
 * */
package day8.B1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        int[] time = new int[N];
        int[] array = new int[N];
        int[] rslt = new int[N];

        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i <N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;

                list.get(pre - 1).add(i); // i를 짓기 위해 pre가 먼저
                array[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // 제일 처음 초기화
        for(int i = 0; i < N; i++){
            if(array[i] == 0){
                queue.offer(i);
                rslt[i] = time[i]; // 처음 시작하는 건 거기에 걸리는 시간 = 최종 걸리는 시간
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : list.get(current)){
                array[next]--;

                // 여기가 이제 핵심 로직
                // 최대 시간 누적 (70% 이햊됨. 내일 다시 볼 것)
                rslt[next] = Math.max(rslt[next], rslt[current] + time[next]);

                if(array[next] == 0){
                    queue.offer(next);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(rslt[i]);
        }


        br.close();
    }
}
