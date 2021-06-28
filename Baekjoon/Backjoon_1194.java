import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1194 달이 차오른다, 가자
public class Backjoon_1194 {
	static class Node {
		int i, j, bit;

		Node() {
		}

		Node(int i, int j, int bit) {
			this.i = i;
			this.j = j;
			this.bit = bit;
		}
	}

	static int N, M;
	static char map[][];

	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };
	static boolean visit[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));

		map = new char[N][M];
		visit = new boolean[64][N][M];
		int num1 = 'F'; // 65
		int num2 = 'f';

		// . 빈곳
		// # 벽 : 이동불가
		// a-f 열쇠 :대응하는 문 열기 가능 (*최대6개) a:97 ,f : 102
		// A-F 문 : 열쇠 있을 때만 이동 가능 (*최대6개) A:65 ,F : 70
		// 0 민식이의 위치
		// 1 출구
		Node start = new Node();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					start = new Node(i, j, 0);
				}
			}
		}

		BFS(start);

	}

	static void BFS(Node start) {
		int bit = 0 , time =0;;
		int x, y;
		int q_size;
		Node node;
		
		boolean isFinish = false;
		Queue<Node> q = new LinkedList();
		q.add(start);
		visit[start.bit][start.i][start.j] = true;

		while (!q.isEmpty() && !isFinish) {
			time++;
			q_size = q.size();
			
			for (int _q = 0; _q < q_size; _q++) {
				node = q.poll();
				for (int d = 0; d < 4; d++) {
					x = node.i + ni[d];
					y = node.j + nj[d];
					if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == '#' || visit[node.bit][x][y])
						continue;

					
					if (map[x][y] == '1') {
						isFinish = true;
						break;
					} else if (map[x][y] >= 'a' && map[x][y] <= 'f') {
						bit = node.bit | 1 << (map[x][y] - 'a');
						visit[bit][x][y] = true;
						q.add(new Node(x, y, bit));

					} else if (map[x][y] >= 'A' && map[x][y] <= 'F') {
						if ((node.bit & 1 << (map[x][y] - 'A')) != 0) {
							visit[node.bit][x][y] = true;
							q.add(new Node(x, y, node.bit));
						}
					} else {
						visit[node.bit][x][y] = true;
						q.add(new Node(x,y,node.bit));
					}

				}
			}
		}
		if(isFinish) System.out.println(time);
		else System.out.println(-1);

	}

}
