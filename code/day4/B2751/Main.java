package day4.B2751;

import java.io.*;
import java.util.*;
/*
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄: 숫자 개수 입력
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        // 숫자들 입력
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for (int num : numbers) {
            bw.write(num + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
*/
// min heap으로 풀기
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 민힙만드러
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 힙 추가
        for (int i = 0; i < n; i++) {
            minHeap.add(Integer.parseInt(br.readLine()));
        }

        // 힙에서 꺼내고 동시에 출력하기.
        while (!minHeap.isEmpty()) {
            bw.write(minHeap.poll() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}