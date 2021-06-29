import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1028 {
	
	static int ni[] = {1,1,-1,-1};

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arr[][] = new int[752][752];
		int dp[][][] = new int[752][752][4]; 
		
		int R,C;
		String s;
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		
		
		
		for(int i=1;i<=R;i++) {
			s = br.readLine();
			for(int j=1;j<=C;j++) {
				arr[i][j] = s.charAt(j-1) - '0';
			}
		}
		
		
		//아래로 뻗어나가는 길이 
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				if(arr[i][j]==1) {
					dp[i][j][0] = dp[i-1][j-1][0]+1;
					dp[i][j][1] = dp[i-1][j+1][1]+1;
				}
			}
		}
		
		// 위로 뻗어나가는 길이
		for(int i=R;i>0;i--) {
			for(int j=1;j<=C;j++) {
				if(arr[i][j]==1) {
					dp[i][j][2] = dp[i+1][j-1][2]+1;
					dp[i][j][3] = dp[i+1][j+1][3]+1;
				}
			}
		}
		
		
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				int k = Math.min(dp[i][j][2], dp[i][j][3]);
				if(k < result) continue;
				for(int l=k;l>0;l--) {
					int rev = (l-1)*2 + i; //반대편 꼭지점
					if(rev > R) continue;
					
					if(dp[rev][j][0] >= l && dp[rev][j][1] >= l) {
						result = Math.max(result, l);
						break;
					}
					
				}
			}
		}
		
		
		System.out.println(result);
		
		
		
		
	}
}
