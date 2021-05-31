// 백준 7562 나이트
// 주소 : https://www.acmicpc.net/problem/7562


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_7562 {
	static int ni[] = {-1,-2,-2,-1,1,2,2,1};
	static int nj[] = {-2,-1,1,2,-2,-1,1,2};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case;
		int start_i, start_j;
		int target_i, target_j;
		int size;
	
		
		st = new StringTokenizer(br.readLine());
		test_case = Integer.parseInt(st.nextToken(" "));
		
		
		
		for(int t = 0;t<test_case;t++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken(" "));
			
			st = new StringTokenizer(br.readLine());
			start_i = Integer.parseInt(st.nextToken(" "));
			start_j = Integer.parseInt(st.nextToken(" "));
			

			st = new StringTokenizer(br.readLine());
			target_i = Integer.parseInt(st.nextToken(" "));
			target_j = Integer.parseInt(st.nextToken(" "));
			
			knight(size,start_i,start_j,target_i,target_j);
			
		}
		
		
	}
	
	static void knight(int size, int start_i, int start_j, int target_i, int target_j) {
		boolean visit[][] = new boolean[size][size];
		int x,y;
		int nx,ny;
		int q_size;
		int move=-1;
		
		boolean find = false;
		Queue<Integer> q = new LinkedList();
		
		q.add(start_i);
		q.add(start_j);
		
		
		
		while(!q.isEmpty() && !find) {
			

			move++;		
			q_size = q.size()/2;
			
			
			for(int i=0;i<q_size;i++) {
				x = q.poll();
				y = q.poll();
				if(x == target_i && y == target_j) {
					find =true;
					break;
				}
				
				
				for(int d=0;d<8;d++) {
					nx = x+ni[d];
					ny = y+nj[d];
					
					if(nx < 0 || ny <0 || nx >=size || ny >=size || visit[nx][ny]) continue;
					
					q.add(nx);
					q.add(ny);
					visit[nx][ny]=true;
					
				}
				
				
			}
			
		}
		
		System.out.println(move);
		
	}
	
}
