import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_2239 {
	
	static public class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int arr[][] = new int[9][9];
	static List<Node> list = new ArrayList<>();
	
	static boolean finish;	
	static boolean space[][] = new boolean[9][10];	
	static boolean row[][] = new boolean[9][10];
	static boolean col[][] = new boolean[9][10];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for(int j=0;j<9;j++) {
				arr[i][j] = s.charAt(j) -'0';
				if(arr[i][j]==0) list.add(new Node(i,j));
				else {
					row[i][arr[i][j]] = true;
					col[j][arr[i][j]] = true;
					space[ (i/3)*3 + (j/3) ][arr[i][j]] = true;
					
				}
			}
		}
		
		sudoku(0);
		

		
	}
	

	static void sudoku(int idx) {
		Node now;
		if(finish) return;
		if(idx == list.size()) {
			finish =true;			
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			return;
		}
		
		now = list.get(idx);
		
		for(int n=1;n<=9;n++) {
			
			if(row[now.i][n] || col[now.j][n] || space[(now.i/3)*3 + (now.j/3)][n]) continue;
						
			row[now.i][n]=true;
			col[now.j][n]=true;
			space[(now.i/3)*3 + (now.j/3)][n] = true;
			arr[now.i][now.j]=n;
			sudoku(idx+1);
			if(finish) return;
			row[now.i][n]=false;
			col[now.j][n]=false;
			space[(now.i/3)*3 + (now.j/3)][n] = false;
			arr[now.i][now.j]=0;
			
		}
		
		
	}
	
}
