import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Backjoon_2618 {
	
	static class Node{
		int i,j;
		
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int[][] dp;
	
	static int N;
	static int W;
	static Node[] jobs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		
		jobs = new Node[W+1];
		
		
		for(int i=1;i<=W;i++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken(" "));
			int x = Integer.parseInt(st.nextToken(" "));
			
			jobs[i] = new Node(y,x);
			
		}
		
		dp = new int[W+1][W+1];
		
		
		
		int answer = solution(1,0,0);
		
		System.out.println(answer);
		
		int first = 0;
		int second = 0;
		
		for(int i=1;i<=W;i++) {
			
			if(dp[first][second] - getDistance(0,first,i) == dp[i][second]) {
				first = i;
				System.out.println(1);
			}
			else {
				second = i;
				System.out.println(2);
			}
					
			
		}
		
		
		
	}
	
	static int solution(int idx, int first, int second) {
		
		if(idx > W) {
			return 0;
		}
		
		
		if(dp[first][second] != 0) {
			return dp[first][second];
		}
		
		
		int firstMovement = solution(idx+1, idx, second) + getDistance(0,first,idx);
		int secondMovement = solution(idx+1, first, idx) + getDistance(1,second,idx);
		
		
		return dp[first][second] = Math.min(firstMovement, secondMovement);
	}
	
	static int getDistance(int num, int start, int end) {
		
		
		if(start == 0) {
			int i = 1 + (num * (N-1));
			int j = 1 + (num * (N-1));
			Node init = new Node(i,j);
			
			return Math.abs(init.i - jobs[end].i)+ Math.abs(init.j - jobs[end].j);
			
		}
		
		
		
		return Math.abs(jobs[start].i - jobs[end].i)+ Math.abs(jobs[start].j - jobs[end].j);
		
		
	}
	
}
