// 백준 14503 로봇 청소기
// 주소 : https://www.acmicpc.net/problem/14503

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14503 {
	
	
	static int n,m; // 가로 세로  3<= n,m <=50
	static int[] robot = new int[3]; // x,y, direction
	static int[][] map = new int[50][50]; 
	static boolean[][] visit = new boolean[50][50];
	static int result; // 청소한 방의 수
	
	static int[] ni = {-1,0,1,0};
	static int[] nj = {0,1,0,-1};	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken(" "));
		m = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<3;i++) {
			robot[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken(" "));	
				// 0 = 빈 공간, 1 = 벽
			}
		}
		runRobot();
		result=result+1;
		System.out.println(result);
	}
	
	static void runRobot() {
		
		int x,y,dir;
		boolean isNotClean;
		
		while(true) {
			
			visit[robot[0]][robot[1]] = true;
			isNotClean = false;
			
			for(int d=0;d<4;d++) {
				dir = (robot[2] + (3-d)) % 4;
				x = robot[0] + ni[dir];
				y = robot[1] + nj[dir];
				
				if(x < 0 || y< 0 || x>=n || y>= m || map[x][y]==1 || visit[x][y]==true) continue;
				
				robot[0] = x;
				robot[1] = y;
				robot[2] = dir;
				visit[x][y] = true;
				isNotClean = true;
				result++;
				break;				
			}
			
			if(isNotClean) continue;
			
			dir = (robot[2]+2) % 4;
			x = robot[0] + ni[dir];
			y = robot[1] + nj[dir];
			
			if(x >=0 && y>=0 && x < n && y < m && map[x][y]!=1) {
				robot[0] =x;
				robot[1] =y;
				continue;
			}
			
			break;
			
		}
		
	}
	
}
