
// 백준 1149 RGB거리
// 주소 : https://www.acmicpc.net/problem/1149

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		int arr[][] = new int[N+1][3];
		int dp[][] = new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken(" "));
			arr[i][1] = Integer.parseInt(st.nextToken(" "));
			arr[i][2] = Integer.parseInt(st.nextToken(" "));
		}
		
	
		
		for(int i=1;i<=N;i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = arr[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]),dp[N][2]));
	}
}
