/**
 * 2025.03.03
 * 백준 11659
 * */
package day2.B11659;

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
		long[] array = new long[n + 1];
		
		st = new StringTokenizer(br.readLine()); 
		
		for(int i = 1; i <= n; i++) {
			array[i] = array[i -1] + Integer.parseInt(st.nextToken());
		}
		
		for(int q = 0; q < m; q++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(array[j] - array[i-1]);
		}
	
	}
}
