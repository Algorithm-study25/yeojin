/*
 * 2025-07-03
 * class2 - 백준 4513번
 * */

package baekjoon.class2.B4513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        String input;
        int[] array = new int[3];
        while(!(input = br.readLine()).equals("0 0 0")){
            for(int i = 0; i < 3; i++) {
                 // array[i] = Integer.parseInt(Arrays.toString((input.split(" "))));
            } // 틀린 코드, 정답은 노션과 깃에
        }

        Arrays.sort(array);

        int a = array[0];
        int b = array[1];
        int c = array[2];

        if(c * c == a * a + b * b){
            System.out.println("right");
        }else{
            System.out.println("wrong");
        }

        br.close();
    }
}
