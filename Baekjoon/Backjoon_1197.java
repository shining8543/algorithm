import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_1197 {
	static class Node implements Comparable<Node>{
		int i,j,w;
		Node(){}
		Node(int i,int j,int w){
			this.i=i;
			this.j=j;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}		
	}
	
	
	
	static void make() {
		parent = new int[V];
		for(int i=0;i<V;i++) {
			parent[i] = i;
		}
	}
	static int findSet(int i) {
		if(parent[i]==i)
			return i;
		return parent[i] = findSet(parent[i]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) 
			return false;
			
		else {
			parent[bRoot] = aRoot;
			
			
			return true;
		}
			
	}
	
	static int parent[];
	static int V,E;
	static long result;
	static List<Node> edge = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int from,to,weight;
		int cnt=0;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken(" "));
		E = Integer.parseInt(st.nextToken(" "));
		
		make();		
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken(" ")) -1;
			to = Integer.parseInt(st.nextToken(" ")) -1;
			weight = Integer.parseInt(st.nextToken(" "));
			
			edge.add(new Node(from,to,weight));
		}
		
		Collections.sort(edge);
		
		for(int i=0;i<edge.size();i++) {
			if(cnt == V-1) break;
			from = edge.get(i).i;
			to = edge.get(i).j;
			weight = edge.get(i).w;
			
			if(union(from,to)) {
				result += weight;
				cnt++;
			}
		}
		System.out.println(result);
	}
}
