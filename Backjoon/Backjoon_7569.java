// 백준 7569 토마토
// 주소 : https://www.acmicpc.net/problem/7569

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_7569 {

	static public class Node {
		int i, j, k;

		Node() {
		}

		Node(int i, int j,int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}

	static int arr[][][] = new int[100][100][100];
	static boolean visit[][][] = new boolean[100][100][100];

	static int M, N, H;

	static int ni[] = { -1, 1, 0, 0, 0, 0 };
	static int nj[] = { 0, 0, -1, 1, 0, 0 };
	static int nk[] = { 0, 0, 0, 0, -1, 1 };

	static int tomato_cnt; // 익지 않은 토마토
	static int visit_cnt; // 익은 토마토

	static Queue<Node> q = new LinkedList();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num;

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken(" ")); // 가로
		N = Integer.parseInt(st.nextToken(" ")); // 세로
		H = Integer.parseInt(st.nextToken(" ")); // 높이

		// 1 익은 토마토 , 0 익지않은 토마토 , -1 : 토마토가 없는 칸
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					num = Integer.parseInt(st.nextToken(" "));
					arr[i][j][k] = num;
					if (num == 1) {
						q.add(new Node(i, j, k));
						visit[i][j][k] = true;
					}
					else if (num == 0) {
						tomato_cnt++;
					}
				}
			}
		}
		
				
		
		
		if(tomato_cnt == 0) System.out.println(0); 
		else
			tomato();
		
		

	}

	static void tomato() {
		Node node;
		int x,y,z;
		int time=-1;
		
		while(!q.isEmpty()) {
			int q_size = q.size();
			time++;
			for(int _q=0;_q<q_size;_q++) {				
				node = q.poll();
								
				for(int d=0;d<6;d++) {
					x = node.i + ni[d];
					y = node.j + nj[d];
					z = node.k + nk[d];
					if(x < 0 || y< 0 || z<0 || x>= N || y>= M || z>=H || visit[x][y][z]) continue;					
					
					if(arr[x][y][z]==1 || arr[x][y][z]==-1) continue;
					
					//System.out.println("방문 : "+x+" "+y+" "+z);
					visit_cnt++;
					visit[x][y][z] = true;
					arr[x][y][z] = 1;
					q.add(new Node(x,y,z));					
				}
				
			}
			
			
			
		}
		if(visit_cnt == tomato_cnt)
			System.out.println(time);
		else {
			System.out.println(-1);
		}
		
		
	}

}
