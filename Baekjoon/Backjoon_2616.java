import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2616 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int K;
		
		st = new StringTokenizer(br.readLine());		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken(" "));
			arr[i] += arr[i-1]; 
		}
		
		int[][] dp = new int[4][N+1];
		
		K = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=3;i++) {
			for(int j=i*K; j<=N;j++) {
					dp[i][j] = Math.max(dp[i][j-1], arr[j]-arr[j-K] + dp[i-1][j-K]);
				}
			}
		
		System.out.println(dp[3][N]);
	}
}
