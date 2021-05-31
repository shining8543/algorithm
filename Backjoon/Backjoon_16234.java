
// 백준 16234 인구 인동
// 주소 : https://www.acmicpc.net/problem/16234

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_16234 {
	static public class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };

	static int N, L, R;
	static int arr[][] = new int[50][50];
	static int result;
	static int guild_cnt;
	static boolean isGuild[][] = new boolean[50][50];
	static boolean isVisit[][] = new boolean[50][50];
	static Queue<Node> guild_q[] = new Queue[2500];// 연합원 멤버
	static boolean isMove;
	static int guild_sum[] = new int[2500];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int open_cnt = 0;

		N = Integer.parseInt(st.nextToken(" "));
		L = Integer.parseInt(st.nextToken(" "));
		R = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));

			}
		}
		guild_cnt = 0;

		while(true) {
			isVisit = new boolean[N][N];
			isMove=false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					find_guild(i, j);
				}
			}
			if(guild_cnt == N) break;
			open_border();
			if(!isMove) break;
			open_cnt++;
			guild_cnt = 0;

		}

		System.out.println(open_cnt);

	}

	static void find_guild(int start_i, int start_j) {
		//Stack<Node> dfs = new Stack();
		Queue<Node> q = new LinkedList();
		int x, y;
		int num;
		int dif;
		Node node;

		if (!isGuild[start_i][start_j]) {
			q.add(new Node(start_i, start_j));
			isVisit[start_i][start_j] = true;
			guild_q[guild_cnt] = new LinkedList();
			guild_q[guild_cnt].add(new Node(start_i, start_j));
			guild_sum[guild_cnt]=arr[start_i][start_j];
			guild_cnt++;			
		} else return;

		while (!q.isEmpty()) {
			node = q.poll();
			num = arr[node.i][node.j];
			for (int d = 0; d < 4; d++) {
				x = node.i + ni[d];
				y = node.j + nj[d];

				if (x < 0 || y < 0 || x >= N || y >= N || isVisit[x][y])
					continue;

				dif = Math.abs(num - arr[x][y]);

				if (dif >= L && dif <= R) {
					//isGuild[x][y] = true;
					isVisit[x][y] = true;					
					guild_q[guild_cnt - 1].add(new Node(x, y));
					guild_sum[guild_cnt-1]+=arr[x][y];
					q.add(new Node(x,y));
				}
			}

		}

	}

	static void open_border() {

	
		Node node;
		int num;
		int guild_member;

		for (int i = 0; i < guild_cnt; i++) {
			guild_member = guild_q[i].size();
			if(guild_member  <= 1) continue;
			num = guild_sum[i] / guild_member;
			
			while (!guild_q[i].isEmpty()) {
				node = guild_q[i].poll();
				
				if(num!=arr[node.i][node.j]) {
					isMove=true;
				}				
				arr[node.i][node.j] = num;
				//isGuild[node.i][node.j] = false;
			}
			
		}
//		arr_print();

	}
	static void arr_print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}
}
