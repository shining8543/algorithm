
// 백준 1938 통나무 옮기기
// 주소 : https://www.acmicpc.net/problem/1938

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1938 {

	static class Node {
		int x;
		int y;

		Node() {
		}

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static char[][] map = new char[50][50];
	static boolean[][] vert_visited = new boolean[50][50]; // 세로상태에서 방문, 가운데 인덱스 값 기준으로 변경
	static boolean[][] hori_visited = new boolean[50][50]; // 가로상태에서 방문
	static Node[] B = new Node[3]; // 통나무 위치 인덱스 1이 중심
	static Node[] E = new Node[3]; // 도착점 위치 인덱스 1이 중심
	static Queue<Node> q1 = new LinkedList();
	static Queue<Node> q2 = new LinkedList();
	static Queue<Node> q3 = new LinkedList();
	static Queue<Boolean> q4 = new LinkedList();

	static int[] ni = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우 , 좌상 우상 좌하 우하 (우원재 하이라는 뜻)
	static int[] nj = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int result = 0;
	static int n; // 평지 한변의 길이 4 <= n <= 50

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		int b_cnt = 0;
		int e_cnt = 0;
		boolean isVertical = false;

		// 지형정보 0 : 평지 , 1 : 잘리지 않은 나무 , B: 나무위치 , E:도착점 위치
		char act; // 행동 = U : 위로, D : 아래 , L : 왼쪽 , R: 오른쪽 , T : 90도회전

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'B') {
					map[i][j] = '0';
					B[b_cnt++] = new Node(i, j);
				} else if (map[i][j] == 'E') {
					E[e_cnt++] = new Node(i, j);
				}

			}
		} // 맵 저장
		if (B[0].y == B[1].y) {
			isVertical = true;
		}
	
		q1.offer(B[0]);
		q2.offer(B[1]);
		q3.offer(B[2]);
		q4.offer(isVertical);
		
		move();

		System.out.println(result);

	}

	static void move() {
		int[] x = new int[3];
		int[] y = new int[3];
		int center_x, center_y;
		Node[] node = new Node[3];
		int q_size;
		int time = 0;
		boolean isFind = false;
		boolean isVertical;
		boolean flag;
		

		
		while (!q1.isEmpty()) {
			q_size = q1.size();


			for (int q = 0; q < q_size; q++) {					
				node[0] = q1.poll();
				node[1] = q2.poll();
				node[2] = q3.poll();
				isVertical = q4.poll();
//				map[node[0].x][node[0].y] = 'B';
//				map[node[1].x][node[1].y] = 'B';
//				map[node[2].x][node[2].y] = 'B';
//				for(int i=0;i<n;i++) {
//					for(int j=0;j<n;j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("------"+time+"----------");
				if (isFinish(node)) {
					isFind = true;
					break;
				}
				for (int d = 0; d < 4; d++) {
					x[0] = node[0].x + ni[d];
					y[0] = node[0].y + nj[d];
					x[1] = node[1].x + ni[d];
					y[1] = node[1].y + nj[d];
					x[2] = node[2].x + ni[d];
					y[2] = node[2].y + nj[d];

					if (x[0] < 0 || y[0] < 0 || x[0] >= n || y[0] >= n || map[x[0]][y[0]] == '1')
						continue;
					if (x[1] < 0 || y[1] < 0 || x[1] >= n || y[1] >= n || map[x[1]][y[1]] == '1')
						continue;
					if (x[2] < 0 || y[2] < 0 || x[2] >= n || y[2] >= n || map[x[2]][y[2]] == '1')
						continue;

					if (isVertical && vert_visited[x[1]][y[1]])
						continue;
					if (!isVertical && hori_visited[x[1]][y[1]])
						continue;

					if (isVertical)
						vert_visited[x[1]][y[1]] = true;
					else
						hori_visited[x[1]][y[1]] = true;

					q1.offer(new Node(x[0], y[0]));
					q2.offer(new Node(x[1], y[1]));
					q3.offer(new Node(x[2], y[2]));

					if (isVertical) {
						vert_visited[x[1]][y[1]] = true;
						q4.offer(true);
					} else {
						hori_visited[x[1]][y[1]] = true;
						q4.offer(false);
					}
				}
				
//				map[node[0].x][node[0].y] = '0';
//				map[node[1].x][node[1].y] = '0';
//				map[node[2].x][node[2].y] = '0';
				
				flag = true;
				while (flag) {
					for (int d = 0; d < 8; d++) {
						x[1] = node[1].x + ni[d];
						y[1] = node[1].y + nj[d];
					

						if (x[1] < 0 || y[1] < 0 || x[1] >= n || y[1] >= n || map[x[1]][y[1]] == '1') {
							flag = false;
							break;
						}
					}
					if (!flag)
						break;
					x[1] = node[1].x;
					y[1] = node[1].y;

					if (isVertical && !hori_visited[x[1]][y[1]]) {
						x[0] = x[1];
						y[0] = y[1] - 1;
						x[2] = x[1];
						y[2] = y[1] + 1;
						q1.offer(new Node(x[0], y[0]));
						q2.offer(new Node(x[1], y[1]));
						q3.offer(new Node(x[2], y[2]));
						q4.offer(false);
						hori_visited[x[1]][y[1]] = true;
						flag = false;
						break;
					} else if (!isVertical && !vert_visited[x[1]][y[1]]) {
						x[0] = x[1] - 1;
						y[0] = y[1];
						x[2] = x[1] + 1;
						y[2] = y[1];
						q1.offer(new Node(x[0], y[0]));
						q2.offer(new Node(x[1], y[1]));
						q3.offer(new Node(x[2], y[2]));
						q4.offer(true);
						vert_visited[x[1]][y[1]] = true;
						flag = false;
						break;
					}
					flag = false;
					break;

				}

				
				
			}
			if(isFind) break;
			time++;
		}
		if (isFind)
			result = time;

	}

	static boolean isFinish(Node[] node) {
		if (node[0].x != E[0].x || node[0].y != E[0].y)
			return false;
		if (node[1].x != E[1].x || node[1].y != E[1].y)
			return false;
		if (node[2].x != E[2].x || node[2].y != E[2].y)
			return false;

		return true;
	}

}
