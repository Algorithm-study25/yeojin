/*
 * 2025-03-10
 * 문제011_백준 1874번
 * */
package day3.B1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int array[] = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        } // 값 입력받기

        Stack<Integer> stk = new Stack<>();
        StringBuffer bf = new StringBuffer(); // bf 쓰는 이유?
        int n = 1;
        boolean rslt = true;

        for(int i = 0; i < array.length; i++){
            int su = array[i];
            if(su >= n){
                while(su >= n){
                    stk.push(n++);
                    bf.append("+\n");
                }
                stk.pop();
                bf.append("-\n");
            }else{
                int top = stk.pop();
                if(top > su){
                    System.out.println("NO");
                    rslt = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }

        }
        if (rslt)
            System.out.print(bf.toString());
        sc.close();
    }
}
