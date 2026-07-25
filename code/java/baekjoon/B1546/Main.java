/**
 * 2025-03-06
 * 백준 1546
 */
package day2.B1546;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] narray = new double[n];
        double max = 0;
        double avg = 0;
        double total = 0;

        for(int i = 0; i < n; i++){
            narray[i] = sc.nextInt();
            if(narray[i] > max){
                max = narray[i];
            }
        }

        for(int i = 0; i < n; i++){
            total = total + ((double)(narray[i]/max) * 100);
        }

        avg = total / n;
        
        System.out.println(n);
        System.out.println(total);
        System.out.println(avg);
        sc.close();
    }
}