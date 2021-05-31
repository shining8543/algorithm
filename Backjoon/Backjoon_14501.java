import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		int T[];
		int P[];
		int DP[];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		T = new int[N];
		P = new int[N];
		DP = new int[N+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken(" ")) - 1;
			P[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		DP[0] = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=i;j>=0;j--) {
				if(i-(T[j]+j) >= 0 && T[j]+j <= N)
					DP[i+1] = Math.max(DP[i+1],DP[j]+P[j]);
			}
		}
		
		for(int i=0;i<N;i++)
			System.out.print(DP[i]+" ");
		System.out.println();
		System.out.println(DP[N]);
			
	}
}
