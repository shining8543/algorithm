// 백준 3040 백설 공주와 일곱 난쟁이
// 주소 : https://www.acmicpc.net/problem/3040

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_3040 {

	static int num[] = new int[9];
	static int choice[] = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		comb(0,0);
		
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0;i<7;i++) {
				sum += choice[i];
			}
			if(sum == 100) {
				for(int i=0;i<7;i++) {
					System.out.println(choice[i]);
				}
			}
		}
		
		else {
			if(idx == 9) return;
			choice[cnt] = num[idx];
			comb(idx+1,cnt+1);
			comb(idx+1,cnt);			
			
		}
		
		
		
		
	}
}
