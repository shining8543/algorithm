// 백준 3052 나머지
// 주소 : https://www.acmicpc.net/problem/3052

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_3052 {
	
	static boolean chk[] = new boolean[42];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int cnt;
		int num;
		
		
		
		cnt = 0;
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken(" "));
			
			num = num%42;
			if(!chk[num]) {
				chk[num] = true;
				cnt++;
			}
			
			
		}
		
		System.out.println(cnt);
		
		
	}
}
