import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N;
		
		N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int d=0;d<3;d++) {
				cost[i][d] = Integer.parseInt(st.nextToken(" "));
			}			
		}
		
		int[][] R = new int[N][3];
		int[][] G = new int[N][3];
		int[][] B = new int[N][3];
		
		
		
		R[0][0] = cost[0][0];
		R[0][1] = 10000;
		R[0][2] = 10000;
		
		G[0][0] = 10000;
		G[0][1] = cost[0][1];
		G[0][2] = 10000;
		
		B[0][0] = 10000;
		B[0][1] = 10000;
		B[0][2] = cost[0][2];
		
		
		for(int i=1;i<N;i++) {
			R[i][0] = Math.min(R[i-1][1], R[i-1][2]) + cost[i][0];
			R[i][1] = Math.min(R[i-1][0], R[i-1][2]) + cost[i][1];
			R[i][2] = Math.min(R[i-1][0], R[i-1][1]) + cost[i][2];
			
			G[i][0] = Math.min(G[i-1][1], G[i-1][2]) + cost[i][0];
			G[i][1] = Math.min(G[i-1][0], G[i-1][2]) + cost[i][1];
			G[i][2] = Math.min(G[i-1][0], G[i-1][1]) + cost[i][2];
			
			B[i][0] = Math.min(B[i-1][1], B[i-1][2]) + cost[i][0];
			B[i][1] = Math.min(B[i-1][0], B[i-1][2]) + cost[i][1];
			B[i][2] = Math.min(B[i-1][0], B[i-1][1]) + cost[i][2];
		}
		
		int rMin = Math.min(R[N-1][1], R[N-1][2]);
		int gMin = Math.min(G[N-1][0], G[N-1][2]);
		int bMin = Math.min(B[N-1][0], B[N-1][1]);

		
		int answer = Math.min(rMin,gMin);
		answer = Math.min(answer, bMin);
		
		System.out.println(answer);
		
		
	}
}
