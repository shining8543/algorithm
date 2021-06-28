import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_9658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		
		boolean dp[] = new boolean[1001];
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		
		dp[1] = true;
		dp[2] = false;
		dp[3] = true;
		dp[4] = false ;
		
		
		for(int i=5;i<=N;i++) {
			if(dp[i-1]||dp[i-3] || dp[i-4] )
				dp[i] = false;
			else
				dp[i] = true;
		}
		
		if(dp[N])
			System.out.println("CY");
		else
			System.out.println("SK");
		
	
		
		
		
	}
}
