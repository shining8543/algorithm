import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2449 {
	static int[][] dp;
	static int[] light;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N,K;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		light = new int[N];
		int[] arr = new int[N];
		dp = new int[N][N];
		int last = -1;
		int idx=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken(" "));
			if(last != arr[i]) {
				last = arr[i];
				light[idx++] = arr[i];
			}
		}
		
		int answer = solve(0, idx-1);
		System.out.println(answer);
		
	}
	
	
	static int solve(int start, int end) {
		if(start == end) {
			return 0;
		}
		
		if(dp[start][end] != 0) {
			return dp[start][end];
		}
		
		
		int result = Integer.MAX_VALUE;
		for(int i=start; i<end;i++) {
			int left = solve(start, i); 
			int right = solve(i+1, end);
				
			
			if(light[start] == light[i+1]) {
				result = Math.min(result, left+right);
			}else {
				result = Math.min(result, left+right+1);				
			}
			
			
		}
		
		
		
		
		
		return dp[start][end] = result;
	}
}	
