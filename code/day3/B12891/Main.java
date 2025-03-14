/**
 *  2025-03-14
 *  문제009_백준 12891번
 * */
package day3.B12891;

import java.util.Scanner;
/*
public class Main {
    static int[] required = new int[4]; // A, C, G, T 최소 몇 개 있는지

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // dna 문자열의 길이
        int P = sc.nextInt(); // 부분 문자열의 길이
        String dna = sc.next(); // dna 문자열

        for(int i=0; i<4; i++){
            required[i] = sc.nextInt();
        }

        int count = 0;
        // 모든 부분 문자열 검사 (O(N*M) 방식)
        for(int i = 0; i <= S-P; i++){ // 시작 인덱스
            int[] current = new int[4];
            // 부분 문자열 내 문자 카운트
            for(int j = i; j< i+P; j++){
                char c = dna.charAt(j);
                switch(c){
                    case 'A': current[0]++; break;
                    case 'C': current[1]++; break;
                    case 'G': current[2]++; break;
                    case 'T': current[3]++; break;
                }
            }
            // 조건 만족 확인
            boolean valid = true;
            for(int k=0; k<4; k++){
                if(current[k] < required[k]){
                    valid = false;
                    break;
                }
            }
            if(valid) count++;
        }
        System.out.println(count);
    }
}*/
public class Main {
    static int[] required = new int[4]; // A, C, G, T 최소 요구량
    static int[] current = new int[4]; // 현재 윈도우 내 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        String dna = sc.next();

        for(int i=0; i<4; i++){
            required[i] = sc.nextInt();
        }

        int count = 0;
        // 초기 윈도우 설정
        for(int i=0; i<P; i++){
            addChar(dna.charAt(i));
        }
        if(checkValid()) count++;

        // 슬라이딩 윈도우 이동
        for(int i=P; i<S; i++){
            removeChar(dna.charAt(i-P));
            addChar(dna.charAt(i));
            if(checkValid()) count++;
        }

        System.out.println(count);
    }

    static void addChar(char c) {
        switch(c){
            case 'A': current[0]++; break;
            case 'C': current[1]++; break;
            case 'G': current[2]++; break;
            case 'T': current[3]++; break;
        }
    }

    static void removeChar(char c) {
        switch(c){
            case 'A': current[0]--; break;
            case 'C': current[1]--; break;
            case 'G': current[2]--; break;
            case 'T': current[3]--; break;
        }
    }

    static boolean checkValid() {
        for(int i=0; i<4; i++){
            if(current[i] < required[i]) return false;
        }
        return true;
    }
}
