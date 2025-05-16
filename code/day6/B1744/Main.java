package day6.B1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int oneCount = 0;
        int zeroCount = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        } // 입력받고

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>((a, b) -> b - a); // 이거는 내림차순으로 바꿔야 함.
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>(); // 이거 이렇게 작성하면 오름차순임.

        for(int i = 0 ; i < N; i++){
            if(arr[i] > 0 || arr[i] != 1){
                positiveQ.add(arr[i]);
            }else if(arr[i] < 0){
                negativeQ.add(arr[i]);
            }else if(arr[i] == 0){
                oneCount++;
            }else if(arr[i] == 1){
                zeroCount++;
            }
        } // 넣어.

        // 양수일때
        while(positiveQ.size() > 1){
            int a = positiveQ.poll();
            int b = positiveQ.poll();
            sum = sum + (a * b);
        }

        if (!positiveQ.isEmpty()) {
            sum += positiveQ.poll(); // 홀수 개면 남은 하나 더함
        }

        // 음수일때
        while(negativeQ.size() > 1){
            int a = negativeQ.poll();
            int b = negativeQ.poll();
            sum = sum + (a * b);
        }

        if(!negativeQ.isEmpty()){
            if(zeroCount == 0){
                sum = sum + negativeQ.poll(); // 0이 없고, negative 큐에 음수가 하나만 남았다면, 그냥 더하는 게 최선
            } // else : 0이 있다면, 남은 음수랑 곱해서 어짜피 0이 돼.
        }

        sum += oneCount;
        System.out.println(sum);
    }
}
