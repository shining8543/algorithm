import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_11657 {
	static class Node{
		int index;
		long weight;
		Node(){}
		Node(int index, long weight){
			this.index = index;
			this.weight = weight;
		}
	}
	static int N,M;
	static long result[];
	static final long INF = 40000000000L;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		List<Node> edge[] = new ArrayList[N+1];
		result = new long[N+1];
		
		for(int i=1;i<=N;i++) {
			edge[i] = new ArrayList();
			edge[i].add(new Node(i,0));
			result[i] = INF;
		}
		result[1] = 0;
		
		int from, to , weight;
		boolean negative_cycle = false;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken(" "));
			to = Integer.parseInt(st.nextToken(" "));
			weight = Integer.parseInt(st.nextToken(" "));
			
			edge[from].add(new Node(to,weight));
		}
		

		
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(Node node : edge[j]){					
					if(result[j]!=INF && result[node.index]> result[j]+node.weight) {
						result[node.index]= result[j]+node.weight; 
					}
				}
			}
		}
		

		
		for(int j=1;j<=N;j++) {
			for(Node node : edge[j]){
				
				if(result[j]!= INF && result[node.index]> result[j]+node.weight) {
					negative_cycle = true;
				}
			}
		}
		
		
		
		
		StringBuilder sb = new StringBuilder();
		if(negative_cycle) sb.append(-1);
		else {
			for(int j=2;j<=N;j++) {
				if(result[j]!=INF)
					sb.append(result[j]).append('\n');
				else
					sb.append(-1).append('\n');
			}
		}
		System.out.println(sb);
		
	}	

	
}
