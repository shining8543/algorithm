import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon_1504 {
	static class Node implements Comparable<Node>{
		int index, weight;
		Node(){}
		Node(int index, int weight){
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			
			return this.weight - o.weight;
		}
	}
	
	static int N,E;
	static List<Node> Edge[];
	static int v1, v2;
	
	static int path[] = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int from,to,weight;
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		E = Integer.parseInt(st.nextToken(" "));
		
		Edge = new ArrayList[N+1];		
		for(int i=1;i<=N;i++) {
			Edge[i] = new ArrayList();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken(" ")) ;
			to = Integer.parseInt(st.nextToken(" ")) ;
			weight = Integer.parseInt(st.nextToken(" "));
			
			Edge[from].add(new Node(to,weight));
			Edge[to].add(new Node(from,weight));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken(" ")) ;
		v2 = Integer.parseInt(st.nextToken(" ")) ;
		
		dijkstra(1,v1,0);
		dijkstra(v1,v2,0);
		dijkstra(v2,N,0);
		
		dijkstra(1,v2,1);
		dijkstra(v2,v1,1);
		dijkstra(v1,N,1);
		

				
		int result = Math.min(path[0], path[1]);

		
		if(result == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(result);
		}
		
		
	}
	
	static void dijkstra(int start_v, int target_v, int path_num) {
		int result[] = new int[N+1];
		boolean visit[] = new boolean[N+1];
		
		PriorityQueue<Node> pq = new PriorityQueue();		
		pq.add(new Node(start_v,0));
		
		Node now;
		
		for(int i=1;i<=N;i++) {
			result[i] = Integer.MAX_VALUE;
		}
		result[start_v] = 0;
				
		
		
		while(!pq.isEmpty()) {
			
			now = pq.poll();
			if(visit[now.index])continue;
			visit[now.index] = true; 
			for(Node node : Edge[now.index]) {
				if(result[node.index] > result[now.index] + node.weight) {
					result[node.index] = result[now.index] + node.weight;
					pq.add(new Node(node.index,result[node.index]));
				}				
			}				
		}
		
		//System.out.println(start_v+" "+target_v+" "+result[target_v]);
		
		if(result[target_v]!=Integer.MAX_VALUE && path[path_num]!=Integer.MAX_VALUE)
			path[path_num] += result[target_v];
		else {
			path[path_num] = Integer.MAX_VALUE;
		}
		
	}
}
