import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N, M;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));

		int[][] arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}

		}

		int[][] L = new int[N + 1][M + 2];
		int[][] R = new int[N + 1][M + 2];

		for(int i=0;i<=N;i++) {
			for(int j=0;j<=M+1;j++) {
				L[i][j] = -100000000;
				R[i][j] = -100000000;
			}
		}
		
		R[0][0] = 0;
		R[0][1] = 0;
		R[1][0] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				R[i][j] = Math.max(R[i - 1][j], L[i - 1][j]);
				R[i][j] = Math.max(R[i][j], R[i][j - 1]);
				R[i][j] += arr[i][j];
			}

			for (int j = M; j > 0; j--) {
				if(i==1) continue;
				L[i][j] = Math.max(R[i - 1][j], L[i - 1][j]);
				if(j != M) {
					L[i][j] = Math.max(L[i][j], L[i][j + 1]);
				}
				L[i][j] += arr[i][j];
			}

		}
		int answer = Math.max(R[N][M], L[N][M]);
		System.out.println(answer);

	}
}
