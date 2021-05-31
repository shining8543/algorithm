import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_14002 {
	static int dp[],idx[], arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		int lis;
		int max_idx;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		dp = new int[N];
		idx = new int[N];
		arr = new int[N];
		lis=1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		
		dp[0] = 1;
		idx[0] = -1;
		max_idx=0;
		for(int i=1;i<N;i++) {			
			idx[i] = -1;
			dp[i]=1;
			for(int j=0; j<i;j++) {
				if(arr[j]< arr[i] && dp[j] >= dp[i]) {
					dp[i] = dp[j]+1;
					idx[i] = j;
				}
				if(dp[i] > lis) {
					lis = dp[i];
					max_idx = i;
				}
			}
		}
		
//		for(int i=0;i<N;i++)
//			System.out.print(idx[i]+" ");		
//		System.out.println();
//		
		System.out.println(lis);
		lis_print(max_idx);		
		System.out.println(sb);
	}
	static void lis_print(int index) {
		if(idx[index] != -1) {
			lis_print(idx[index]);
			sb.append(arr[index]).append(" ");
		}else {
			sb.append(arr[index]).append(" ");
		}
		
	}
}
