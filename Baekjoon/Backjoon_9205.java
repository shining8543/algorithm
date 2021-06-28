
// 백준 9205 맥주 마시면서 걸어가기
// 주소 : https://www.acmicpc.net/problem/9205


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_9205 {
	static class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t,n;
		
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken(" "));
		int dp[][]= new int[102][102];
		Node pos[] = new Node[102];
		int x,y;
		int temp_x; 
		int temp_y;
		
		
		for(int _t=0;_t<t;_t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken(" "));
			
			for(int i=0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken(" "));
				y = Integer.parseInt(st.nextToken(" "));
				pos[i] = new Node(x,y);
			}
			
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					if(i==j) dp[i][j] = 0;
					else {								
						temp_x = Math.abs(pos[i].i - pos[j].i);
						temp_y = Math.abs(pos[i].j - pos[j].j);
						dp[i][j] = temp_x + temp_y;
						if(dp[i][j]>1000) dp[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			for(int k=0;k<n+2;k++) {
				for(int i=0;i<n+2;i++) {
					if(k==i) continue;
					for(int j=0;j<n+2;j++) {
						if(i==j || k==j) continue;
						if(dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
						
						if(dp[i][j] > dp[i][k]+dp[k][j])
							dp[i][j] = dp[i][k]+dp[k][j];
					}
				}
			}
//			for(int i=0;i<n+2;i++) {
//				for(int j=0;j<n+2;j++){
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			if(dp[0][n+1]!=Integer.MAX_VALUE) System.out.println("happy");
			else System.out.println("sad");
		}
		
	}
}
