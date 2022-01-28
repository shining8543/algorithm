import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N, K;

		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));

		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin);
		
		int[] dp = new int[K+1];
		
		dp[0] = 1;
		
		for(int i=0;i<N;i++) {
			for(int j=1;j<=K;j++) {
				if(j-coin[i] >= 0) {
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		
		System.out.println(dp[K]);
		

	}
}
