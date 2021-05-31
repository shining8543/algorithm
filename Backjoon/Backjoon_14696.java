
// 백준 14696 딱지놀이
// 주소 : https://www.acmicpc.net/problem/14696

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14696 {
	
	
	// 별 > 동그라미 > 네모 > 세모
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int round;
		int me[] = new int[5];
		int you[] = new int[5];
		int cnt,num;
		
		st = new StringTokenizer(br.readLine());
		round = Integer.parseInt(st.nextToken(" "));
		
		for(int r=0;r<round;r++) {
			
			for(int i=1;i<=4;i++) {
				me[i] =0;
				you[i] = 0;
			}
			
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken(" "));
			for(int i=0;i<cnt;i++) {			
				num = Integer.parseInt(st.nextToken(" "));
				me[num]++;
			}
			
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken(" "));
			for(int i=0;i<cnt;i++) {			
				num = Integer.parseInt(st.nextToken(" "));
				you[num]++;
			}
			
			for(int i=4;i>0;i--) {
				if(me[i] > you[i]) {
					System.out.println("A");
					break;
				}
				else if(me[i] < you[i]) {
					System.out.println("B");
					break;
				}
				
				if(i==1) System.out.println("D");
			}
			
			
			
			
		}
		
	}
}
