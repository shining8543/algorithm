import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1600 {

	static class Node {
		int i, j, k;

		Node() {
		}

		Node(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}

	static int K, W, H;
	static int arr[][] = new int[200][200];
	static boolean visit[][][] = new boolean[31][200][200];
	static int result;

	static int ni[] = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int nj[] = { 0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int nk[] = { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken(" "));

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken(" "));
		H = Integer.parseInt(st.nextToken(" "));
		result = Integer.MAX_VALUE;

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		BFS();

	}

	static void BFS() {

		Queue<Node> q = new LinkedList();
		int x, y,z;
		Node node;

		int q_size;
		int time = -1;
		boolean flag = false;
		
		visit[0][0][0] = true;
		q.add(new Node(0,0,0));
		
		while (!q.isEmpty()) {
			time++;
			q_size = q.size();

			for (int _q = 0; _q < q_size; _q++) {
				node = q.poll();
				if(node.i==H-1 && node.j == W-1) {
					q.clear();
					flag = true;
					break;
				}
				for(int d=0;d<12;d++) {
					x = node.i+ni[d];
					y = node.j+nj[d];
					z = node.k+nk[d];
					
					if(x<0 || y<0 || x>=H || y>= W || z>K || arr[x][y] == 1 || visit[z][x][y]) continue;
					
					visit[z][x][y] = true;
					q.add(new Node(x,y,z));
					
					
				}
				
				
				}

		}
		if(flag)
			System.out.println(time);
		else
			System.out.println(-1);
	}

}
