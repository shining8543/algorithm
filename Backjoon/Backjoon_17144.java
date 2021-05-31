import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_17144 {
	static class Node {
		int i, j, dust;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

		Node(int i, int j, int dust) {
			this.i = i;
			this.j = j;
			this.dust = dust;
		}
	}

	static int arr[][] = new int[50][50];
	static int R, C, T;

	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };
	static Node air_cond[] = new Node[2];

	static Queue<Node> dust = new LinkedList();
	static Queue<Node> move = new LinkedList();
	static boolean isDust[][] = new boolean[50][50];
	static int dust_remain;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int air_cond_cnt = 0;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		T = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				if (arr[i][j] == -1) {
					air_cond[air_cond_cnt++] = new Node(i, j);
				} else {
					dust_remain += arr[i][j];
				}
			}
		}

//		System.out.println("작동 전 : " + dust_remain);
		flow();
		System.out.println(dust_remain);

	}

	static void flow() {

		int time = 0;
		int q_size;
		int x, y;
		int dust_out;
		int air_i, air_j, temp;
		Node node;

		while (true) {
			if (time == T)
				break;

			time++;
			q_size = dust.size();
			for (int i = 0; i < R; i++) {
				for (int j= 0; j < C;j++) {
					dust_out = arr[i][j] / 5;

					for (int d = 0; d < 4; d++) {
						x = i + ni[d];
						y = j + nj[d];

						if (x < 0 || y < 0 || x >= R || y >= C || arr[x][y] == -1)
							continue;

						arr[i][j] -= dust_out;
						move.add(new Node(x, y, dust_out));
					}
				}
			}
			// 먼지 확산
			while (!move.isEmpty()) {
				node = move.poll();
				arr[node.i][node.j] += node.dust;
				
			} // 확산된 먼지 도착
//			System.out.println("-------먼지확산 후---------");
//			print_arr();

			// 에어컨 위에꺼 시작
			air_i = air_cond[0].i;
			air_j = air_cond[0].j;

			dust_remain -= arr[air_i - 1][0];

			for (int i = air_i; i > 0; i--) {
				arr[i][0] = arr[i - 1][0];
			} // 에어컨에게 내려오는거

			arr[air_i][0] = 0;

			for (int j = 0; j < C - 1; j++) {
				arr[0][j] = arr[0][j + 1];
			} // 좌로 가는거

			for (int i = 0; i < air_i; i++) {
				arr[i][C - 1] = arr[i + 1][C - 1];
			} // 위로 가는거

			for (int j = C - 1; j > 0; j--) {
				arr[air_i][j] = arr[air_i][j - 1];
			} // 오른쪽으로 가는거
			arr[air_i][0] = -1;
//			System.out.println("-------------------위에어컨----");
//			print_arr();
//			System.out.println("----------------------------");
			// 에어컨 아래꺼 시작
			air_i = air_cond[1].i;
			air_j = air_cond[1].j;

			dust_remain -= arr[air_i + 1][0];

			for (int i = air_i; i < R - 1; i++) {
				arr[i][0] = arr[i + 1][0];
			} // 위로

			arr[air_i][0] = 0;

			for (int j = 0; j < C - 1; j++) {
				arr[R - 1][j] = arr[R - 1][j + 1];
			} // 좌로 가는거

			for (int i = R - 1; i > air_i; i--) {
				arr[i][C - 1] = arr[i - 1][C - 1];
			} // 아래로 가는거
			for (int j = C - 1; j > 0; j--) {
				arr[air_i][j] = arr[air_i][j - 1];
			} // 오른쪽으로 가는거

			arr[air_i][0] = -1;

//			System.out.println("-------------------아래에어컨----");
//			print_arr();
//			System.out.println("----------------------------");
		} // while 끝

	}

	static void print_arr() {
		int num = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j] + " ");
				num += arr[i][j];
			}
			System.out.println();
		}
		num += 2;
		System.out.println("남은 먼지 : " + num);
	}

}
