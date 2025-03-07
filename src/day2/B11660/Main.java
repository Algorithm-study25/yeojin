/*
 * 2025-03-07
 * 백준 11660번
 * */

package day2.B11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] array = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				array[i][j] = array[i][j -1] + Integer.parseInt(st.nextToken());	
			}
		} // 한 줄씩 다 전체 합 구해둠
		
		int[][] intervalarray = new int[n][4];
		
		for(int i = 0; i< n; i++) {
			for(int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				intervalarray[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력받고
	
		for(int i = 1; i <= m; i++) { // m은 3
			int s = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int j = x1; j <= x2; j++) {
                s = s + (array[j][y2] - array[j][y1-1]);
            }
            sb.append(array + "\n");	
		}
		System.out.print(sb);
	}
}
