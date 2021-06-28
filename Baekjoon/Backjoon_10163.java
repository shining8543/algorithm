
// 백준 10163 색종이
// 주소 : https://www.acmicpc.net/problem/10163

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_10163 {
	static int arr[][] = new int[101][101];
	static int ans[] = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int x, y, x_length, y_length;

		int paper_cnt;
		st = new StringTokenizer(br.readLine());
		paper_cnt = Integer.parseInt(st.nextToken(" "));

		for (int p = 1; p <= paper_cnt; p++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken(" "));
			y = Integer.parseInt(st.nextToken(" "));
			x_length = Integer.parseInt(st.nextToken(" "));
			y_length = Integer.parseInt(st.nextToken(" "));
			
			for(int i=0;i<x_length;i++) {
				for(int j=0;j<y_length;j++) {
					arr[x+i][y+j] = p;
				}
			}			
		}
		
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				ans[arr[i][j]]++;
			}
		}
		
		for(int i=1;i<=paper_cnt;i++)
			System.out.println(ans[i]);
	}
}
