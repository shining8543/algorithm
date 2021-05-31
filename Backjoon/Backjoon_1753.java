import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon_1753 {
	static class Node implements Comparable<Node>{
		int index, distance;
		Node(int index,int distance){
			this.index = index;
			this.distance = distance;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
	}
	static int V, E;
	static List<Node> W[];
	static int distance[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int from, to, weight;
		int start_v;
		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken(" "));
		E = Integer.parseInt(st.nextToken(" "));

		distance = new int[V];
		
		W = new ArrayList[V];
		
		for(int i=0;i<V;i++) {
			W[i] = new ArrayList<Node>();
		}

		st = new StringTokenizer(br.readLine());
		start_v = Integer.parseInt(st.nextToken(" ")) - 1;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			from = Integer.parseInt(st.nextToken(" ")) - 1;
			to = Integer.parseInt(st.nextToken(" ")) - 1;
			weight = Integer.parseInt(st.nextToken(" "));

			W[from].add(new Node(to,weight));
		}
		dijkstra(start_v);
		distance[start_v] = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < V; i++)
			if(distance[i]!=Integer.MAX_VALUE)
				sb.append(distance[i]).append('\n');
			else
				sb.append("INF\n");
		
		System.out.println(sb);
	}

	static void dijkstra(int start_v) {
		int min_distance;
		int min_index;
		visit = new boolean[V];		
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for(int i=0;i<V;i++)
			distance[i] = Integer.MAX_VALUE;
		
		distance[start_v] = 0;
		pq.add(new Node(start_v,0));
		
		
		while(!pq.isEmpty()) {
			
			int now = pq.poll().index;
			
			if(visit[now]) continue;
			visit[now] = true;
			
			
			for(int i=0;i<W[now].size();i++) {
				if(distance[now] + W[now].get(i).distance < distance[W[now].get(i).index]) {
					distance[W[now].get(i).index] = distance[now] + W[now].get(i).distance;
					pq.add(new Node(W[now].get(i).index, distance[W[now].get(i).index]));
				}
				
			}
			
		}
		
		

	}
}
