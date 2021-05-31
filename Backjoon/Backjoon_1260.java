
// 백준 1260 DFS와 BFS
// 주소 : https://www.acmicpc.net/problem/1260


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_1260 {
	static boolean[][] graph = new boolean[1001][1001];
	static int[] ans = new int[1000];
	static boolean[] use_dfs = new boolean[1001];
	static boolean[] use_bfs = new boolean[1001];
	static Queue<Integer> queue = new LinkedList();
	static Stack<Integer> stack = new Stack();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		int N, M, V;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		V = Integer.parseInt(st.nextToken(" "));



		int num1, num2;

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken(" "));
			num2 = Integer.parseInt(st.nextToken(" "));
			graph[num1][num2] = true;
			graph[num2][num1] = true;
		}
		
		
		DFS(V, N);
		BFS(V, N);
	}

	static void DFS(int root, int N) {
		StringBuilder sb = new StringBuilder();
		use_dfs[root] = true;
		stack.push(root);
		sb.append(root);
		sb.append(" ");
		while(!stack.isEmpty()) {
			root = stack.pop();
			
			for(int i=1;i<=N;i++) {
				if(!use_dfs[i] && graph[root][i]){
					use_dfs[i] = true;
					stack.push(root);
					stack.push(i);
					sb.append(i);
					sb.append(" ");				
					break;		
				}			
				
			}			
		}
		System.out.println(sb);

	}

	static void BFS(int root, int N) {
		StringBuilder sb = new StringBuilder();

		use_bfs[root] = true;
		queue.add(root);
		sb.append(root);
		sb.append(" ");
		
		while (!queue.isEmpty()) {
			root = queue.poll();
			for(int i=1;i<=N;i++) {
				if(!use_bfs[i] && graph[root][i]) {
					use_bfs[i] = true;
					queue.add(i);	
					sb.append(i);
					sb.append(" ");
				}
			}
		}
		System.out.println(sb);
	}

}