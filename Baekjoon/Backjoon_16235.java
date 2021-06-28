import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_16235 {
	static class Node implements Comparable<Node> {
		int i, j, age;

		Node() {
		}

		Node(int i, int j, int age) {
			this.i = i;
			this.j = j;
			this.age = age;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Node> tree = new PriorityQueue();
		Queue<Node> live = new LinkedList();
		Queue<Node> dead = new LinkedList();

		int N, M, K;
		int x, y, age;
		int map[][];
		int s2d2[][];

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken(" ")); // N x N 크기의 땅
		M = Integer.parseInt(st.nextToken(" ")); // 나무의 수
		K = Integer.parseInt(st.nextToken(" ")); // K년 지난 후의 나무의 수

		s2d2 = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				s2d2[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken(" "))-1;
			y = Integer.parseInt(st.nextToken(" "))-1;
			age = Integer.parseInt(st.nextToken(" "));
			tree.add(new Node(x, y, age));
		}

		int q_size;
		Node node;
		int ni[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int nj[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int t = 0; t < K; t++) {

			// 봄 시작
			q_size = tree.size();
			for (int q = 0; q < q_size; q++) {
				node = tree.poll();

				if (map[node.i][node.j] >= node.age) {
					map[node.i][node.j] -= node.age;
					live.add(new Node(node.i, node.j, node.age + 1));
				} else {
					dead.add(new Node(node.i, node.j, node.age / 2));
				}

			}
			// 봄 끝

			// 여름 시작
			while (!dead.isEmpty()) {
				node = dead.poll();
				map[node.i][node.j] += node.age;
			}
			// 여름 끝

			// 가을 시작
			while (!live.isEmpty()) {
				node = live.poll();
				tree.add(node);
				
				if (node.age % 5 == 0) {

					for (int d = 0; d < 8; d++) {
						x = node.i + ni[d];
						y = node.j + nj[d];
						if(x<0 || y<0 || x>= N || y>=N) continue;
						
						tree.add(new Node(x,y,1));
					}
				}
				
			}
			//가을 끝
			
			//겨울 시작
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] += s2d2[i][j];
				}
			}
			
			//겨울 끝
			
			

		}
		System.out.println(tree.size());

	}
}
