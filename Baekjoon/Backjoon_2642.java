import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2642 {
	static final int LEFT = 0;
	static final int RIGHT = 1;
	static final int FRONT = 2;
	static final int BACK = 3;
	static final int UP = 4;
	static final int DOWN = 5;
	static public class Node{
		// left , right, front , back, up, down
		int[] num;;
		int cnt;
		
		public Node() {
			this.num = new int[6];
			this.cnt = 0;
		}
		void rotate(int k) {
			int temp;
			
			if(k==0) {
				temp = num[DOWN];
				num[DOWN] = num[RIGHT];
				num[RIGHT] = num[UP];
				num[UP] = num[LEFT];
				num[LEFT] = temp;
			}else if(k==1) {
				temp = num[DOWN];
				num[DOWN] = num[FRONT];
				num[FRONT] = num[UP];
				num[UP] = num[BACK];
				num[BACK] = temp;
			}else if(k==2) {
				temp = num[DOWN];
				num[DOWN] = num[LEFT];
				num[LEFT] = num[UP];
				num[UP] = num[RIGHT];
				num[RIGHT] = temp;
			}else {
				temp = num[DOWN];
				num[DOWN] = num[BACK];
				num[BACK] = num[UP];
				num[UP] = num[FRONT];
				num[FRONT] = temp;
			}
			
		}
		
		
		
	}
	
	static int[] ni = {1,0,-1,0};
	static int[] nj = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] arr = new int[6][6];
		boolean[][] visited = new boolean[6][6];
		
		int y=0,x=0;
		
		for(int i=0;i<6;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				
				if(arr[i][j]!=0) {
					y = i;
					x = j;
				}
			}
			
		}
		Node node = new Node();
		if(!check(node, arr[y][x],y,x,arr,visited) || node.cnt != 6) {
			System.out.println(0);
		}else {
			for(int i=0;i<6;i++) {
				if(node.num[i]==1) {
					int answer =i  -2*(i%2) + 1;
					System.out.println(node.num[answer]);
					break;
				}
			}
		}
		
		
		
		
		
	}
	
	
	
	
	static boolean check(Node node, int now, int i, int j, int[][] arr, boolean[][] visited) {
		for(int d=0;d<4;d++) {
			int y = ni[d] + i;
			int x = nj[d] + j;
			
			if(x < 0 || y < 0 || x>= 6 || y >= 6 || arr[y][x] ==0 || visited[y][x]) {
				continue;
			}
			
			visited[y][x] = true;
			int next = arr[y][x];
			node.rotate(d);
			if(node.num[DOWN] != 0) {
				return false;
			}
			node.num[DOWN] = next;
			node.cnt++;
			
			check(node,next,y,x,arr,visited);
			node.rotate((d+2)%4);
			
			
			
		}
		
		
		return true;
	}
}
