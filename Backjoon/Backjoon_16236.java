import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_16236 {
	static class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N;
	static int arr[][] = new int[20][20];
	static int arr2[][] = new int[20][20];
	static int num = 1;
	static int ni[] = { -1, 0, 0, 1 };
	static int nj[] = { 0, -1, 1, 0 };
	static int fish_cnt;
	static Node shark;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				if (arr[i][j] == 9) {
					shark = new Node(i, j);
					arr[i][j] = 0;
				} else if (arr[i][j] != 0)
					fish_cnt++;

			}
		}
		bfs();

	}

	static void bfs() {
		Node node;
		int x, y, shark_size = 2;
		int time = -1;
		int eat_cnt = 0;
		boolean visit[][] = new boolean[N][N];
		boolean eat;
		Queue<Node> q = new LinkedList();
		Queue<Node> fq = new LinkedList();
		q.add(shark);
		visit[shark.i][shark.j] = true;

		int result = 0;
		int q_size;
		while (!q.isEmpty() && fish_cnt > 0) {
			q_size = q.size();
			time++;
			for (int _q = 0; _q < q_size; _q++) {
				node = q.poll();
				if(arr[node.i][node.j]!=0 && arr[node.i][node.j] < shark_size) {
					fish_cnt--;
					eat_cnt++;
					arr[node.i][node.j]= 0; 
					arr2[node.i][node.j]= num++; 
					if(eat_cnt == shark_size) {
						eat_cnt = 0;
						shark_size++;
					}
					result = time;
					if(fish_cnt == 0)break;
				}
				
				
				for (int d = 0; d < 4; d++) {
					x = node.i + ni[d];
					y = node.j + nj[d];

					if (x < 0 || y < 0 || x >= N || y >= N || visit[x][y])
						continue;

					if (arr[x][y] < shark_size) {
						if (arr[x][y] != 0) {
							visit = new boolean[N][N];
							fq.add(new Node(x, y));
							visit[x][y] = true;
						} else {
							q.add(new Node(x, y));
							visit[x][y] = true;
						}

					} else if (arr[x][y] == shark_size) {

						q.add(new Node(x, y));
						visit[x][y] = true;
					}
				}
			
			}
			int f_i=N,f_j=N;
			while(!fq.isEmpty()) {
				node = fq.poll();
				
				if(node.i < f_i) {
					f_i = node.i;
					f_j = node.j;
					q.clear();
					q.add(new Node(f_i,f_j));
				} else if(node.i == f_i && node.j <= f_j) {
					f_j = node.j;
					q.clear();
					q.add(new Node(f_i,f_j));
				}
				visit = new boolean[N][N];					
			}

		}

		System.out.println(result);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}

	}

}
