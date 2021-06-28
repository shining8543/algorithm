import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2636 {
	static class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	static int N,M;
	static int arr[][] = new int[100][100];
	static int cheese_cnt;
	static int outside_cheese;
	static boolean visit[][] = new boolean[100][100];
	static Queue<Node> air_q = new LinkedList();
	static Queue<Node> cheese_q = new LinkedList();
	
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				if(arr[i][j]==1) cheese_cnt++;
			}
		}
		int time=0;
		air_q.add(new Node(0,0));
		visit[0][0] = true;
		
		while(cheese_cnt!=0) {
			BFS();
			time++;
		}
		System.out.println(time);
		System.out.println(outside_cheese);
		
	}
	
	static void BFS() {
		
		Node node;
		int x,y;
		outside_cheese = 0;
		while(!air_q.isEmpty()) {
			node = air_q.poll();
			
			for(int d=0;d<4;d++) {
				x = node.i + ni[d];
				y = node.j + nj[d];
				
				if(x<0 || y<0 || x>= N || y>= M || visit[x][y]) continue;
				
				
				visit[x][y] = true;
				
				if(arr[x][y]==0) 				
					air_q.add(new Node(x,y));
				
				else if(arr[x][y]==1) 					
					cheese_q.add(new Node(x,y));
				
				
			}
		}
		
		if(cheese_q.size() == cheese_cnt) {
			outside_cheese = cheese_cnt;
			cheese_cnt = 0;
			return;
		}
		
		while(!cheese_q.isEmpty()) {			
			node = cheese_q.poll();
			outside_cheese++;
			arr[node.i][node.j]= 0; 
			air_q.add(node);			
		}
		
		cheese_cnt -= outside_cheese;
		
		
	}
	
}
