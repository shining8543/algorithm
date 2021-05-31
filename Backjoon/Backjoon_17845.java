import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,K;
		int I[],T[],dp[][], result=0;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" ")); //최대 공부 시간
		K = Integer.parseInt(st.nextToken(" ")); //과목 수
		
		I = new int[K+1]; // 중요도
		T = new int[K+1]; // 공부 시간
		dp = new int[K+1][N+1];
		
		System.out.println(K+" "+N);
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine());
			I[i] = Integer.parseInt(st.nextToken(" "));
			T[i] = Integer.parseInt(st.nextToken(" "));	
		}
		
		for(int i=1;i<=K;i++) {
			for(int j=1;j<=N;j++) {
				if(T[i]<=j) {
					dp[i][j] = Math.max(I[i]+dp[i-1][j-T[i]], dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];					
				}
				
			}
			
		}
		System.out.println(dp[K][N]);
		
		
	}
}
