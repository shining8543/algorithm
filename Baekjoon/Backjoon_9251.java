import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s1,s2;
		
		s1 = br.readLine();
		s2 = br.readLine();
		
		int dp[][] = new int[1001][1001];
		
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1]+1;
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				
			}
		}
		
		System.out.println(dp[s1.length()][s2.length()]);
	}
}
