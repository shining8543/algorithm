import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_15685 {
	static class Node{
		int i,j,dir;
		Node(){}
		Node(int i,int j,int dir){
			this.i= i;
			this.j=j;
			this.dir =dir;
		}
		
		
	}
	
	
	static int ni[] = {0,-1,0,1};
	static int nj[] = {1,0,-1,0};
	static int arr[][] = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x=0,y=0,dir=0,gen=0;
		int N;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
	
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken(" "));
			x = Integer.parseInt(st.nextToken(" "));
			dir = Integer.parseInt(st.nextToken(" "));
			gen = Integer.parseInt(st.nextToken(" "));
			//System.out.println("드래곤 커브");
			dragon_curve(x,y,dir,gen);
		}
		
		
		int temp;
		int result =0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				temp = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
				//System.out.print(arr[i][j]+" ");
				if(temp==4) result++;
			}
			//System.out.println();
		}
		System.out.println(result);
		
		
	}
	
	static void dragon_curve(int start_x, int start_y, int start_dir, int start_gen ) {
		
		Stack<Integer> path = new Stack();
		Queue<Integer> next_path = new LinkedList();
		Stack<Integer> last_path = new Stack();
		int x,y,dir,t_dir;
		int gen = start_gen;
		dir = start_dir;
		//System.out.println("gen("+"0"+") "+dir);
		x = start_x+ni[dir];
		y = start_y+nj[dir];
		arr[start_x][start_y]=1;
		arr[x][y]=1;
		dir = (dir+1)%4;
		last_path.add(dir);
		
		for(int g=0; g<=gen; g++) {
			int stack_size = path.size();
			for(int s=0;s<stack_size;s++) {
				dir = path.pop();
				//System.out.println("gen("+g+","+s+") "+dir);
				x = x + ni[dir];
				y = y + nj[dir];
				//System.out.println(x+" "+y);
				last_path.add(dir);		
				dir = (dir+1)%4;
				
				arr[x][y]=1;
				next_path.add(dir);				
				}
			
			while(!last_path.isEmpty()) {	
				t_dir = last_path.pop();
				path.add(t_dir);
			}
			
			while(!next_path.isEmpty()) {
				t_dir = next_path.poll();
				path.add(t_dir);
			}
		}
		
	}
	

	
	
}
