
// 백준 15684 사다리 조작
// 주소 : https://www.acmicpc.net/problem/15684


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_15684 {

	static int N, M, H; // N <=10 , H<=30, M <= 290
	static boolean connect[][] = new boolean[30][10];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num, height;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		H = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			height = Integer.parseInt(st.nextToken(" ")) - 1;
			num = Integer.parseInt(st.nextToken(" ")) - 1;

			connect[height][num] = true;
		}
		result = 4;

		DFS(0, 0);
		if (result == 4)
			result = -1;
		System.out.println(result);
	}

	static void DFS(int idx, int cnt) {
		
		// System.out.println("cnt = "+cnt);
		ladder(cnt);

		if (cnt >= 3) {
			return;
		}
		
		if (idx >= (N - 1) * H)
			return;
		int x, y;
		x = idx / (N - 1);
		y = idx % (N - 1);
		// System.out.println(idx+" : "+x+" "+y);

		if (!connect[x][y]) {
			if ((y <= 0 || !connect[x][y - 1]) || (y >= (N - 1) || !connect[x][y + 1])) {
				connect[x][y] = true;
				DFS(idx + 1, cnt + 1);
				connect[x][y] = false;
			}
		}

		DFS(idx + 1, cnt);

	}

	static void ladder(int cnt) {
		int pos, height;

		for (int i = 0; i < N; i++) {
			pos = i;
			height = 0;
			while (height != H) {
				if (connect[height][pos])
					pos++;
				else if (pos >= 1 && connect[height][pos - 1])
					pos--;
				// System.out.println(pos);
				height++;
			}
			// System.out.println(pos+" "+i);
			if (pos != i)
				return;
		}
		result = Math.min(result, cnt);

	}
}
