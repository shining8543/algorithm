
// 백준 17406 배열돌리기4
// 주소 : https://www.acmicpc.net/problem/17406

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17406 {
	static int n, m, k;

	static int[][] original_arr = new int[51][51];
	static int[][] arr = new int[51][51];

	static int result;

	static int[] r = new int[6];
	static int[] c = new int[6];
	static int[] s = new int[6];
	static int[] order = new int[6]; // 순서 저장

	static int[] ni = { 1, 0, -1, 0 };
	static int[] nj = { 0, 1, 0, -1 };

	static boolean[] isChoice = new boolean[6];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken(" "));
		m = Integer.parseInt(st.nextToken(" "));
		k = Integer.parseInt(st.nextToken(" "));

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				original_arr[i][j] = Integer.parseInt(st.nextToken(" "));
				arr[i][j] = original_arr[i][j];
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken(" "));
			c[i] = Integer.parseInt(st.nextToken(" "));
			s[i] = Integer.parseInt(st.nextToken(" "));
		}
		result = Integer.MAX_VALUE;
		perm(0);
		System.out.println(result);

	}

	static void rotate(int r, int c, int s) {
		int x_start = r - s;
		int x_end = r + s;
		int y_start = c - s;
		int y_end = c + s;
		int x,y,d;
		int nx,ny;
		int tmp;
		int timer=0;
		
		
		while (true) {
			tmp = arr[x_start+timer][y_start+timer];
			d=0;
			x = x_start + timer;
			y = y_start + timer;
			while(d<4) {
				nx = x + ni[d];
				ny = y + nj[d];
				if(nx>=x_start+timer && ny>=y_start+timer && nx <= x_end-timer && ny<= y_end-timer) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				} else {
					d++;
				}
				
				
			
			}
			arr[x_start+timer][y_start+timer+1] = tmp;
			timer++;
			if(timer >= s) {
				break;
			}
			
		}
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("-------------------------");

	}

	static void perm(int cnt) {
		int tmp_result = 0;
		if (cnt == k) {
			for (int i = 1; i <= n; i++) {
				for(int j=1;j<=m;j++) {
					arr[i][j] = original_arr[i][j];
				}
				
			}
//			System.out.println("----------회전하기 전----------");
//			for(int i=1;i<=n;i++) {
//				for(int j=1;j<=m;j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("-------------------------");

			
			for (int i = 0; i < k; i++) {
//				System.out.println(i+"번째 차례 : "+order[i]);
				rotate(r[order[i]], c[order[i]], s[order[i]]);
			}
			for (int i =1; i<=n;i++) {
				tmp_result = 0;
				for (int j = 1; j<=m;j++) {
					tmp_result += arr[i][j];
				}
				result = Math.min(result, tmp_result);
//				System.out.println("중간 결과 : "+result);
			}
		}

		for (int i = 0; i < k; i++) {
			if (isChoice[i]) continue;
			isChoice[i] = true;
			order[cnt] = i;
			perm(cnt + 1);
			isChoice[i] = false;
		}

	}

}
