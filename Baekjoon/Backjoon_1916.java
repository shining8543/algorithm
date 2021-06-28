import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon_1916 {
	static class Node implements Comparable<Node>{
		int index,weight;
		Node(){}
		Node(int index, int weight){
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	static int N,M;
	static List<Node> edge[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int from,to,weight;
		
		st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		
		edge = new ArrayList[N];
		for(int i=0;i<N;i++) {
			edge[i] = new ArrayList();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken(" ")) -1;
			to = Integer.parseInt(st.nextToken(" ")) -1;
			weight = Integer.parseInt(st.nextToken(" "));
			
			
			edge[from].add(new Node(to,weight));
			
		}
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken(" ")) -1;
		to = Integer.parseInt(st.nextToken(" ")) -1;
		dijkstra(from,to);
	}
	
	
	static void dijkstra(int start_v, int end_v) {
		int result[] = new int[N];
		boolean visit[] = new boolean[N];
		for(int i=0;i<N;i++) {
			result[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue();
		
		result[start_v] = 0;
		pq.add(new Node(start_v,0));
				
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			if(visit[now]) continue;
			visit[now] = true;
		
			
			for(Node node : edge[now]) {
				if(result[node.index] > result[now]+node.weight) {
					result[node.index] =  result[now]+node.weight;
					pq.add(new Node(node.index, result[node.index]));
				}
			}
			
		}
		System.out.println(result[end_v]);
	}
}
