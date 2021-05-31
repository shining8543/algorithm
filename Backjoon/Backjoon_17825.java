import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17825 {
	static class Node {
		int way, idx, num;

		Node() {
		}

		Node(int way, int idx, int num) {
			this.way = way;
			this.idx = idx;
			this.num = num;
		}
	}

	static int route[][] = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0 }, // 22
			{ 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40, 0 }, // 14
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40, 0 }, // 18
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40, 0 } // 24
	};
	static int route_way[] = new int[23];
	static int dice[] = new int[10];

	static Node horse[] = new Node[4];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++)
			dice[i] = Integer.parseInt(st.nextToken(" "));
		// 주사위 입력 완료

		for (int i = 0; i < 23; i++) {
			route_way[i] = 0;
		}

		for (int i = 0; i < 4; i++) {
			horse[i] = new Node(0, 0, 0);
		}

		DFS(0, 0);
		System.out.println(result);

	}

	static void DFS(int idx, int sum) {
		if (idx == 10) {
//			if(sum > result) {
//				for(int i=0;i<4;i++) {
//					System.out.println(horse[i].way+" "+horse[i].num);
//				}
//				System.out.println(sum);
//				System.out.println("------------------------");
//			}

			result = Math.max(result, sum);

			return;
		}

		int last_idx, last_num;
		for (int i = 0; i < 4; i++) {// 움직일 말 선택

			if (horse[i].idx == -1)
				continue; // 이미 주행이 끝난 말이면 스킵

			if (horse[i].way == 0) {
				if (horse[i].idx == 5 && isOnlyOne(i, 1, idx)) {
					last_idx = horse[i].idx;
					last_num = horse[i].num;
					if (isRouteOver(i, 1, idx)) {
						horse[i].idx = -1;
						horse[i].num = 0;
					} else {
						horse[i].idx += dice[idx];
						horse[i].num = route[1][horse[i].idx];
					}
					horse[i].way = 1;
					DFS(idx + 1, sum + horse[i].num);
					horse[i].idx = last_idx;
					horse[i].num = last_num;
					horse[i].way = 0;

				} else if (horse[i].idx == 10 && isOnlyOne(i, 2, idx)) {
					last_idx = horse[i].idx;
					last_num = horse[i].num;
					if (isRouteOver(i, 2, idx)) {
						horse[i].idx = -1;
						horse[i].num = 0;

					} else {
						horse[i].idx += dice[idx];
						horse[i].num = route[2][horse[i].idx];
					}
					horse[i].way = 2;
					DFS(idx + 1, sum + horse[i].num);
					horse[i].idx = last_idx;
					horse[i].num = last_num;
					horse[i].way = 0;
				} else if (horse[i].idx == 15 && isOnlyOne(i, 3, idx)) {
					last_idx = horse[i].idx;
					last_num = horse[i].num;
					if (isRouteOver(i, 3, idx)) {
						horse[i].idx = -1;
						horse[i].num = 0;
					} else {
						horse[i].idx += dice[idx];
						horse[i].num = route[3][horse[i].idx];
					}
					horse[i].way = 3;
					DFS(idx + 1, sum + horse[i].num);
					horse[i].idx = last_idx;
					horse[i].num = last_num;
					horse[i].way = 0;
				} else if (horse[i].idx != 5 && horse[i].idx != 10 && horse[i].idx != 15 && isOnlyOne(i, 0, idx)) {

					last_idx = horse[i].idx;
					last_num = horse[i].num;
					if (isRouteOver(i, 0, idx)) {
						horse[i].idx = -1;
						horse[i].num = 0;

					} else {
						horse[i].idx += dice[idx];
						horse[i].num = route[0][horse[i].idx];
					}
					DFS(idx + 1, sum + horse[i].num);
					horse[i].idx = last_idx;
					horse[i].num = last_num;
				}

			} else if (horse[i].way != 0) {
				last_idx = horse[i].idx;
				last_num = horse[i].num;
				if (isRouteOver(i, horse[i].way, idx)) {
					horse[i].idx = -1;
					horse[i].num = 0;
					DFS(idx + 1, sum + horse[i].num);
				} else {
					if (isOnlyOne(i, horse[i].way, idx)) {
						horse[i].idx += dice[idx];
						horse[i].num = route[horse[i].way][horse[i].idx];
						DFS(idx + 1, sum + horse[i].num);
					}
				}
				horse[i].idx = last_idx;
				horse[i].num = last_num;
			}

		}

	}

	static boolean isOnlyOne(int i, int dir, int idx) {

		if (isRouteOver(i, dir, idx))
			return true;

		if (dir != 0) {

			for (int n = 0; n < 4; n++) {
				if (i == n || horse[n].idx == -1)
					continue;

				if (horse[n].way == 0 && horse[n].num == 30)
					continue;

				if (horse[n].way != 0 && horse[n].num == route[dir][horse[i].idx + dice[idx]]) {
					return false;
				}

				if (horse[n].num == 40 && route[dir][horse[i].idx + dice[idx]] == 40)
					return false;
				// 기본루트가 아닌 경우에 가려고 하는 위치가 값이 겹치는 경우

			}
		}

		else {
			for (int n = 0; n < 4; n++) {
				if (i == n || horse[n].idx == -1)
					continue;
				if (horse[n].way != 0 && horse[n].num == 30)
					continue;
				if ((horse[n].way == horse[i].way && horse[n].idx == horse[i].idx + dice[idx])
						|| (horse[n].num == 40 && route[dir][horse[i].idx + dice[idx]] == 40))
					return false;
			}

		}

		return true;
	}

	static boolean isRouteOver(int i, int dir, int idx) {

		if (dir == 0 && horse[i].idx + dice[idx] >= 22) {
			return true;
		} else if (dir == 1 && horse[i].idx + dice[idx] >= 14) {
			return true;
		} else if (dir == 2 && horse[i].idx + dice[idx] >= 18) {
			return true;
		} else if (dir == 3 && horse[i].idx + dice[idx] >= 24) {
			return true;
		}

		return false;
	}
}
