import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2933 {
	static class Node implements Comparable<Node>{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
		@Override
		public int compareTo(Node o) {
			
			return this.i - o.i;
		}
	}
	
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int R,C,N;
		char arr[][];
		String s;
		int order[];
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		
		arr = new char[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken(); 
			for(int j=0;j<C;j++) {
				 arr[i][j] = s.charAt(j);					 
			}
		}
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		order = new int[N]; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			order[i] = Integer.parseInt(st.nextToken(" "));
		
		//입력 끝
		
		simulate(arr,R,C,order,N);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');			
		}
		System.out.println(sb);
		
	}//main-end
	
	static void simulate(char arr[][], int R, int C, int order[], int N ) {
		
		int h;
		
		for(int t=0;t<N;t++) {
			h = R-order[t];
			
			if(t%2==0) { //왼쪽에서 던지는 경우
				for(int j=0;j<C;j++) {
					if(arr[h][j]=='x') {
						arr[h][j]='.';
						if(h-1 >= 0 && arr[h-1][j]=='x' && isDrop(h-1,j,arr,R,C))
							drop_simulate(h-1,j,arr,R,C);
						
						if(h+1 <R && arr[h+1][j]=='x' && isDrop(h+1,j,arr,R,C) ) {
							drop_simulate(h+1,j,arr,R,C);
						}
						
						if(j-1 >=0 && arr[h][j-1]=='x' && isDrop(h,j-1,arr,R,C) )
							drop_simulate(h,j-1,arr,R,C);
						
						if(j+1 <C && arr[h][j+1]=='x' && isDrop(h,j+1,arr,R,C) )
							drop_simulate(h,j+1,arr,R,C);
						
						break;
					}					
				}
				
				
			}else { //오른쪽에서 던지는 경우
				for(int j=C-1;j>=0;j--) {
					if(arr[h][j]=='x') {
						arr[h][j] = '.';
						if(h-1 >= 0 && arr[h-1][j]=='x' && isDrop(h-1,j,arr,R,C) )
							drop_simulate(h-1,j,arr,R,C);
						
						if(h+1 <R && arr[h+1][j]=='x' && isDrop(h+1,j,arr,R,C) )
							drop_simulate(h+1,j,arr,R,C);
						
						if(j-1 >=0 && arr[h][j-1]=='x' && isDrop(h,j-1,arr,R,C) )
							drop_simulate(h,j-1,arr,R,C);
						
						if(j+1 <C && arr[h][j+1]=='x' && isDrop(h,j+1,arr,R,C) )
							drop_simulate(h,j+1,arr,R,C);
						
						break;
					}
				}
				
				
			}
			
			
			//print(arr,R,C);
//			System.out.println("------------------");
			
			
			
		}
		//for-end
		
		
		
	}
	//simulate-end
	
	static boolean isDrop(int di,int dj,char arr[][],int R,int C) {
		//떨어지는 클러스터인지 확인
		int ni[] = {-1,1,0,0};
		int nj[] = {0,0,-1,1};
		
		int x,y;
		Boolean isSafe = false;
		boolean visit[][] = new boolean[R][C];
		visit[di][dj] = true;
		Node node;
		Queue<Node> q = new LinkedList();
		
		q.add(new Node(di,dj));
		
		if(di==R-1) isSafe = true;
		
		while(!q.isEmpty()) {
			node = q.poll();
			if(isSafe) break;
			for(int d=0;d<4;d++) {
				x = node.i+ni[d];
				y = node.j+nj[d];
				if(x<0 || y<0 || x>= R || y>=C || arr[x][y]=='.' || visit[x][y]) continue;
				
				if(x==R-1) {
					isSafe = true; //바닥과 연결된 미네랄이 있으면 safe
					return false;
				}
				
				visit[x][y]=true;
				q.add(new Node(x,y));
				
			}
			
		}
		
		return !isSafe;
		
	}
	
	static void drop_simulate(int di,int dj,char arr[][],int R,int C) {
		Queue<Node> seek = new LinkedList();
		PriorityQueue<Node> drop = new PriorityQueue();
		Queue<Node> next_drop = new LinkedList();
		
		
		Node node;
		
		int x,y;
		int ni[] = {-1,1,0,0};
		int nj[] = {0,0,-1,1};
		
		boolean visit[][] = new boolean[R][C];
		boolean isSafe = false;
		
		visit[di][dj] = true;
		arr[di][dj] = '.';
		seek.add(new Node(di,dj));
		drop.add(new Node(di,dj));		
		
		while(!seek.isEmpty()) {
			node = seek.poll();
			
			for(int d=0;d<4;d++) {
				x = node.i+ni[d];
				y = node.j+nj[d];
				if(x< 0 || y<0|| x>=R || y>=C || arr[x][y]=='.' || visit[x][y]) continue;
				
				visit[x][y] = true;
				arr[x][y] = '.';
				seek.add(new Node(x,y));
				drop.add(new Node(x,y));	
			}
			
		}
		//클러스트 그룹 찾으며 drop 큐에 담기

		//print(arr,R,C);
		
		int q_size;
		while(!drop.isEmpty()) {
			if(isSafe) break;
			q_size = drop.size();
			
			for(int q=0;q<q_size;q++) {
				node = drop.poll();
				next_drop.add(new Node(node.i+1,node.j));
				if((node.i+1) == R-1 || arr[node.i+2][node.j]=='x') {
					isSafe = true;
				}
				//바닥 혹은 다른 미네랄을 만날 때까지 드롭
			}
			if(!isSafe)
				while(!next_drop.isEmpty()) {
					drop.add(next_drop.poll());
				}
			else {
				while(!next_drop.isEmpty()) {
					node = next_drop.poll();
					arr[node.i][node.j] ='x'; 
				}
			}
			
		}
		
		
	}
	
	
	
	static void print(char arr[][], int R,int C) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.printf("%3c",arr[i][j]);
			}
			System.out.println();
		}
	}
}

