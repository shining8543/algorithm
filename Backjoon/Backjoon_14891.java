
// 백준 14891 톱니바퀴
// 주소 : https://www.acmicpc.net/problem/14891


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14891 {
	
	static int gear[][] = new int[5][8];
	static boolean visit[] = new boolean[5];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int turn_cnt;
		
		int target_gear, direction; // 1 시계방향 ,-1 반시계
		
		String s;
		
		for(int i=1;i<=4;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken(" ");
			for(int j=0;j<8;j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		
		st = new StringTokenizer(br.readLine());
		turn_cnt = Integer.parseInt(st.nextToken(" "));
		
		
		for(int i=0;i<turn_cnt;i++) {
			st = new StringTokenizer(br.readLine());
			target_gear = Integer.parseInt(st.nextToken(" "));
			direction = Integer.parseInt(st.nextToken(" "));
			
			for(int b=1;b<=4;b++) {
				visit[b] = false;
			}
			
			gear_turn(target_gear,direction);
			
		}
		
		int result=0;
		int score=1;
		
		
	
//		for(int i=1;i<=4;i++) {
//			for(int j=0;j<8;j++) {
//				System.out.print(gear[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------");
		
		for(int i=1;i<=4;i++) {
			//System.out.println(gear[i][0]);
			if(gear[i][0]==1) {
				result+=score;
			}
			score *=2;
		}
		System.out.println(result);

		
	}
	
	static void gear_turn(int idx, int direct) {
		
		if(visit[idx]) return;
		
		visit[idx] = true;
		
		
		int temp;
		
		if(direct==1) {
									
			
			temp = gear[idx][7];
			for(int i=7;i>0;i--) {
				gear[idx][i] = gear[idx][i-1];				
			}			
			gear[idx][0]=temp;

			
			if(idx-1 >= 1) {
				if(gear[idx][7] != gear[idx-1][2]) {
					gear_turn(idx-1, -1);
				}
			}
			if(idx+1 <= 4) {
				if(gear[idx][3] != gear[idx+1][6]) {
					gear_turn(idx+1,-1);
				}
			}
			
			
			
		}else {

			temp = gear[idx][0];
			for(int i=0;i<7;i++) {
				gear[idx][i] = gear[idx][i+1];
			}
			gear[idx][7] = temp;
			
			if(idx-1 > 0) {
				if(gear[idx][5] != gear[idx-1][2]) {
					gear_turn(idx-1, 1);
				}
			}
			if(idx+1 <= 4) {
				if(gear[idx][1] != gear[idx+1][6]) {
					gear_turn(idx+1,1);
				}
			}
			
		}
		
	}
	
}

