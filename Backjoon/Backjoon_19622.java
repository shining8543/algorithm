
// 백준 19622 회의실 배정3
// 주소 : https://www.acmicpc.net/problem/19622

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_19622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		int start,end,num;
		int dp[];
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		dp = new int[N+1];		
		dp[0] = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken(" "));
			end = Integer.parseInt(st.nextToken(" "));
			num = Integer.parseInt(st.nextToken(" "));
			if(i<2) {
				dp[i] = Math.max(dp[0],num);
			}else {
				dp[i] = Math.max(dp[i-2]+num, dp[i-1]);
			}
			// 각 위치까지 범위라고 생각했을 때 선택 여부 상관없이 최대값 저장
		}
		System.out.println(dp[N-1]);
		
		
		
	}
}
