
// 백준 1260 DFS와 BFS
// 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_1260_bit {
	static int[] graph = new int[1001];
	static int ans[] = new int[1000];
	static int isFinish;
	static Queue<Integer> queue = new LinkedList();
	static Stack<Integer> stack = new Stack();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int bit;
		int N, M, V;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		V = Integer.parseInt(st.nextToken(" "));

		bit = 1 << 1000;
		
		int num1, num2;

		for (int i = 1; i < N; i++) {
			graph[i] = graph[i] | 1 << N;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken(" "));
			num2 = Integer.parseInt(st.nextToken(" "));
			graph[num1] = graph[num1] | 1 << (num2 - 1);
			graph[num2] = graph[num2] | 1 << (num1 - 1);
		}
		
		DFS(bit, V, N);
	//	BFS(bit, V, N);
	}

	static void DFS(int bit, int root, int N) {
		StringBuilder sb = new StringBuilder();
		int num;
		int cnt=0;
		bit = bit | 1 << (root - 1);
		stack.push(root);
		sb.append(root);
		sb.append(" ");

		while(cnt !=N) {
			root = stack.pop();
			System.out.println(root);
			
			for(int i=0;i<N;i++) {
				if((bit & 1 << i) == 0 && (graph[root] & 1 << i) !=0){
					System.out.println("큐에 삽입 : "+i);
					bit = bit | 1 << i;
					queue.add(root);
					queue.add(i+1);
					sb.append(i+1);
					sb.append(" ");
					cnt++;
					break;		
				}			
				
			}			
		}
		System.out.println(sb);
		
	
	}

	static void BFS(int bit, int root, int N) {
		StringBuilder sb = new StringBuilder();

		bit = bit | 1 << (root - 1);
		queue.add(root);
		
		int stack_size;
		
		while (!queue.isEmpty()) {
			
			
			int queue_size = queue.size();
			for (int q = 0; q < queue_size; q++) {	
				for(int i=0; i< N; i++) {
					if((bit & 1 << i) == 0 && (graph[root] & 1 << i)!=0){
						bit = bit | 1 << i;
						queue.add(i+1);
						break;						
					}				
				}			
				root = queue.poll();			
				sb.append(root);
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}

}
