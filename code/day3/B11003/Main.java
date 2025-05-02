/**
 *  2025-03-10
 *  문제010_백준 11003번
 * */
package day3.B11003;
/*
import java.util.Scanner;

public class Main {
    static int N;
    static int L;
    static int[] array;
    static int[] partArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 전체 수열의 길이
        L = sc.nextInt(); // 최솟값을 구하는 범위
        array = new int[N];
        partArray = new int[L];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }

        // 초기 윈도우 설정
        for(int i = 0; i < L && i < N; i++){
            addInt(i);
        }
        System.out.print(findMin() + " ");

        // 슬라이딩 윈도우
        for(int i = L; i < N; i++){
            addInt(i);
            System.out.print(findMin() + " ");
        }
        sc.close();
    }

    static void addInt(int i){
        partArray[i % L] = array[i];
    }
    static int findMin(){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < L; i++){
            min = Math.min(min, partArray[i]);
        }
        return min;
    }
}
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기
        int L = Integer.parseInt(st.nextToken()); // 최솟값을 구하는 범위

        st = new StringTokenizer(br.readLine());
        Deque<Node> d = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!d.isEmpty() && d.getLast().value > now) {
                d.removeLast();
            }

            d.addLast(new Node(now, i));

            if (d.getFirst().index <= i - L) {
                d.removeFirst();
            }
            bw.write(d.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
