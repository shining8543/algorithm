import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_11438 {
	static class Node{
		int in,out,depth;
		Node(){}
		Node(int in,int out){
			this.in = in;
			this.out = out;
		}
		Node(int in,int out,int depth){
			this.in = in;
			this.out = out;
			this.depth = depth;
		}
	}
	
	static int N;
	static boolean visit[];
	static Node tree[];
	static List<Integer> edge[];
	static int parent[][];
	static int point;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int v1,v2;
		int M,in,out,start_v;
		int max_depth;
		int temp;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		edge = new List[N+1];
		tree = new Node[N+1];
		visit = new boolean[N+1];
		max_depth = 0;
		temp = 1;
		while(temp<= N) {
			temp <<=1;
			max_depth++;
		}
		
		
		parent = new int[max_depth][N+1];
		
		
		for(int i=1;i<=N;i++) {
			edge[i] = new ArrayList();			
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken(" "));
			v2 = Integer.parseInt(st.nextToken(" "));
			edge[v1].add(v2);
			edge[v2].add(v1);
		}
		//입력 끝
		point = 1;
		tree[1] = new Node(1,0,0);
		parent[0][1] = 1;
		visit[1] = true;
		
		DFS(1,1); //트리 탐색 및 깊이 설정
		find_parent(max_depth);
		
	
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken(" "));
			v2 = Integer.parseInt(st.nextToken(" "));

			
			if(v1 == 1 || v2 == 1 ) sb.append(1).append('\n');
			else sb.append(find_LCA(v1,v2,max_depth)).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	static void DFS(int idx,int depth) {
		
		
		for(int v : edge[idx]) {
			if(visit[v]) continue;
			visit[v] = true;
			tree[v] = new Node(++point,0,depth+1);
			parent[0][v] = idx;
			DFS(v,depth+1);
		}
		
		tree[idx].out = ++point;
		
	}
	
	static void find_parent(int max_depth) {
		for(int i=1;i<max_depth;i++) {
			for(int j=1;j<=N;j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
			}
		}
	}
	
	
	static int find_LCA(int a, int b,int max_depth) {
		if(tree[a].depth < tree[b].depth) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int i=max_depth-1; i>=0;i--) {
			if(Math.pow(2, i) <= tree[a].depth - tree[b].depth)
				a = parent[i][a];
		}
		
		if(a==b) return a;
		
		
		for(int i=max_depth-1; i>=0;i--) {
			if(parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		return parent[0][a];
		
	}
	
}
