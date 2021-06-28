// 백준 8320 직사각형을 만드는 방법
// 주소 : https://www.acmicpc.net/problem/8320

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_8320 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken(" "));
		int cnt = 0;
		
		
		for(int i=1;i<=n;i++) {
			for(int j=i;i*j <= n; j++) {
				cnt++;
			}			
		}
		System.out.println(cnt);
		
	}
}
