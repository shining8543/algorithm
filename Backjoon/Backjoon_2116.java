
// 백준 2116 주사위 쌓기
// 주소 : https://www.acmicpc.net/problem/2116

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2116 {
	static int dice[][] = new int[10000][6];
	static int dice_cnt;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());		
		dice_cnt = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<dice_cnt;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				dice[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		roll_dice();
		System.out.println(result);
		
	}
	
	//주사위 0-5 1-3 2-4 
	static void roll_dice() {
		int r_idx[] = {5,3,4,1,2,0};
		int down,idx=0;
		int num,cnt;
		int t_result;
		
		for(int r=0;r<6;r++) {
			down = dice[0][r];
			cnt=0;
			t_result=0;
			while(cnt < dice_cnt) {
				for(int i=0;i<6;i++) {
					if(down == dice[cnt][i]) {
						idx = i;
						down = dice[cnt][r_idx[idx]];
						break;
					}
				}
				num=0;
				for(int i=0;i<6;i++) {
					if(i==idx || i==(r_idx[idx])) continue;
					num = Math.max(num, dice[cnt][i]);
				}
				t_result += num;
				cnt++;
				
				
			}
			result = Math.max(result,t_result);
			
		}
		
	}
	
}
