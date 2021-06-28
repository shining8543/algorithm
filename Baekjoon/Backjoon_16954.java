import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_16954 {
	
	static class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static final int N = 8;
	static char arr[][] = new char[9][8];
	static char dot[] = {'.','.','.','.','.','.','.','.'};
	static int ni[]=  {-1,-1,-1,0,0,0,1,1,1};
	static int nj[] = {-1,0,1,-1,0,1,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for(int j=0;j<N;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		if(simulate()) System.out.println(1);
		else System.out.println(0);
		
	}
	
	static boolean simulate() {
		
		boolean flag = false;
		
		int x,y;
		int q_size;
		Node node;
		Queue<Node> q = new LinkedList();
		
		q.add(new Node(N-1,0));
		
		int turn=0;
		
		while(!q.isEmpty()){
			q_size = q.size();
			for (int _q = 0; _q < q_size && !flag; _q++) {
				node = q.poll();
				if(arr[node.i][node.j]== '#' ) continue;
				
				for (int d = 0; d < 9; d++) {
					x = node.i + ni[d];
					y = node.j + nj[d];
					if(x < 0 || y<0|| x>=N || y>= N || arr[x][y]=='#') continue;
					
					if(x==0 && y == N-1) {
						flag = true;
						q.clear();
						break;
					}
					
					q.add(new Node(x,y));
					
				}
				
				
				
			}
			
			if(flag) break;
			
			
			for(int i=N-1;i>0;i--) {
				arr[i] = arr[i-1];
			}
			arr[0] = dot;

		}
		
		if(flag) return true;
		else return false;
	}
}
