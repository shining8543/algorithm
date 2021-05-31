
// 백준 2178 미로 탐색
// 주소 : https://www.acmicpc.net/problem/2178

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2178 {

	static public class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};

	static int result;
	static int N, M;
	static int map[][] = new int[100][100];

	static Queue<Node> q = new LinkedList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));

		result = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}		}
		q.add(new Node(0, 0));			
		seek();
		System.out.println(result);
	}

	static void seek() {
		int x, y;
		int q_size;
		Node now;
		int time=1;
		
		while (!q.isEmpty()) {

			q_size = q.size();
			for (int i = 0; i < q_size; i++) {
				now = q.poll();
				
				for (int d = 0; d < 4; d++) {
					x = ni[d] + now.i;
					y = nj[d] + now.j;
					
					if(x < 0 || y < 0 || x>= N || y>=M || map[x][y]==0) continue;
					
					if(x==N-1 && y == M-1) {
						result = time+1;
						return;
					}
					map[x][y] = 0;					
					q.add(new Node(x,y));					

				}
			}
			time++;

		}
	}

}
