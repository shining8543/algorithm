//백준 3985 롤 케이크
//주소 : https://www.acmicpc.net/problem/3985

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_3985 {
	static boolean[] rollcake = new boolean[1001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int rollcake_len;
		
		int hope_max_cnt=0;
		int hope_max_num=0;
		int real_max_cnt=0;
		int real_max_num=0;
		int cnt;
		
		int hope_start ,hope_end;
		
		rollcake_len = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		
		
		for(int k=1;k<=t;k++) {
			st = new StringTokenizer(br.readLine());
			hope_start = Integer.parseInt(st.nextToken());
			hope_end = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			
			if(hope_max_cnt < (hope_end-hope_start+1)) {
				hope_max_cnt = hope_end - hope_start + 1;
				hope_max_num = k;
			}
			
			
			for(int i=hope_start;i<=hope_end;i++) {
				if(!rollcake[i]) {
					cnt++;
					rollcake[i] = true;
				}
			}
			
			if(real_max_cnt < cnt ) {
				real_max_cnt = cnt;
				real_max_num = k;
			}
			
		}
		
		System.out.println(hope_max_num);
		System.out.println(real_max_num);
		
	}
}
