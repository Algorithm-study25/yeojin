/*
 * 2025-07-03
 * class2 - 백준 1181
 * */

package baekjoon.class2.B1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            wordSet.add(br.readLine());
        }

        // ArrayList<String> array = new ArrayList<>();
        List<String> wordList = new ArrayList<>(wordSet);

        // 정렬 기준에 따라
        // 1) 길이 2) 사전
        wordList.sort((s1, s2) -> {
            if(s1.length() != s2.length()){
                return s1.length() - s2.length(); // 길이 짧은 순
            }else{
                return s1.compareTo(s2);
            }
        });

        for (String word : wordList) {
            System.out.println(word);
        }
    }
}
