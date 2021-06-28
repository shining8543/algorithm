// 백준 16926 배열돌리기1
// 주소 : https://www.acmicpc.net/problem/16926

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_16926 {
	static int n, m, r;
	static int[][] arr = new int[1000][1000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken(" "));
		m = Integer.parseInt(st.nextToken(" "));
		r = Integer.parseInt(st.nextToken(" "));

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		rotate();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sb.append(arr[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	static void rotate() {
		int temp;
		int time = 0;
		while (true) {
			for(int k = 0; k<r;k++) {
			temp = arr[time + 1][time + 1];
			for (int j = 1 + time; j <= m - (time+1); j++) { // 상단 회전
				arr[1 + time][j] = arr[1 + time][j + 1];
			}

			// arr[time][m-time] = arr[time+1][m-time];

			for (int i = time + 1; i <= n-(time + 1); i++) { // 우측
				arr[i][m - time] = arr[i + 1][m - time];
			}

			for (int j = m - time; j > time + 1; j--) {// 하단
				arr[n - time][j] = arr[n - time][j - 1];
			}

			for (int i = n - time; i > time + 1; i--) {
				arr[i][time + 1] = arr[i - 1][time + 1];
			}
			arr[time + 2][time + 1] = temp;
			}
			time++;
			if(1+time > (n/2) || 1+time > (m/2)) break;
		}
	}
}
