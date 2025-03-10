/*
 * 2025.03.05
 * 문제_005 백준 10986번
 * */
package day2.B10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] array = new int[n];
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
 		}
		
		int[] sumarray = new int[n];
		for(int i = 0; i < n; i++) {
			sumarray[i] += array[i];
			if(sumarray[i] / m == 0) {
				count++;
			}
		}
	}
}
