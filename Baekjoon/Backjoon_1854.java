// 백준 1854 K번째 최단경로 찾기
// 주소 : https://www.acmicpc.net/problem/1854


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon_1854 {
	static class Node implements Comparable<Node>{
		int index=-1,weight;
		Node(){}
		Node(int weight){
			this.weight=weight;
		}
		Node(int index,int weight){
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(index==-1) return o.weight - this.weight;
			return this.weight - o.weight;
		}
	}
	
	static int n,m,k;
	static int distance[];	
	static List<Node> W[];
	static int arr[][] = new int[1001][1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken(" "));
		m = Integer.parseInt(st.nextToken(" "));
		k = Integer.parseInt(st.nextToken(" "));
		
		
		W = new ArrayList[n+1];
		
		for(int i=1;i<=n;i++)
			W[i] = new ArrayList();
		
		int from,to,weight;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			from = Integer.parseInt(st.nextToken(" "));
			to = Integer.parseInt(st.nextToken(" "));
			weight = Integer.parseInt(st.nextToken(" "));
			
			if(arr[from][to]!=0) {
				while(true) {
					
				}
			}
			
			W[from].add(new Node(to,weight));
			
		}
		
		
		
		dijkstra();
		
		
	}
	
	static void dijkstra() {
		int visit[] = new int[n+1];
		int k_cnt=0;
		PriorityQueue<Node> result[] = new PriorityQueue[n+1];
		PriorityQueue<Node> pq = new PriorityQueue();
		
		for(int i=1;i<=n;i++) {
			result[i] = new PriorityQueue();
		}
		
		
		pq.add(new Node(1,0));
		result[1].add(new Node(0));
		
		
		Node now;
		
		while(!pq.isEmpty()) {
			
			
			now = pq.poll();	
			if(visit[now.index]== k) {				
				continue; 
			}
			visit[now.index]++;
			
			for(Node node : W[now.index]) {				
				
				if(result[node.index].size()<k || now.weight + node.weight <= result[node.index].peek().weight) {
					result[node.index].add(new Node(now.weight+node.weight));
					if(result[node.index].size()>k) result[node.index].poll();
					pq.add(new Node(node.index, now.weight+ node.weight));
					
				}
				
				
				
			}
			
		}
	
		
		for(int i=1;i<=n;i++) {
			if(result[i].size()<k) System.out.println(-1);
			else System.out.println(result[i].peek().weight);
		}
		
		
	}
	
}
