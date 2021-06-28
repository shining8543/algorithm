import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_7576 {
	static class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	static int N,M;
	
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arr[][];
		int tomato_cnt=0, ripen_tomato_cnt=0;
		Queue<Node> ripen_tomato = new LinkedList();
		
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		N = Integer.parseInt(st.nextToken(" "));
		
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				if(arr[i][j]==0) tomato_cnt++;
				else if(arr[i][j]==1) {
					ripen_tomato.add(new Node(i,j));
				}
			}
		}
		
		
		ripe(arr,tomato_cnt,ripen_tomato);
		
		
		
	}
	
	static void ripe(int arr[][],int tomato_cnt,Queue<Node> ripen_tomato ) {
		
		int q_size,x,y,time=0;
		Node node;
		
		
		
		
		while(!ripen_tomato.isEmpty()) {			
			q_size = ripen_tomato.size();
			if(tomato_cnt==0) break;
			time++;
			for(int q=0;q<q_size;q++) {				
				node = ripen_tomato.poll();				
				
				for(int d=0;d<4;d++) {
					x = node.i + ni[d];
					y = node.j + nj[d];
					if(x<0 || y<0|| x>=N || y >= M || arr[x][y]==1 || arr[x][y] == -1) continue;
					
					arr[x][y]=1;
					ripen_tomato.add(new Node(x,y));
					tomato_cnt--;
				}
				
				
				
			}
			
			
			
		}
		
		if(tomato_cnt !=0) time=-1;
		System.out.println(time);
		
		
	}
	
}
