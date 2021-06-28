
// 백준 4779 칸토어 집합
// 주소 : https://www.acmicpc.net/problem/4779

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_4779 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		String s;
		
		s = br.readLine();
		
		do {
			
			N = Integer.parseInt(s);
			if(N==0) sb.append('-');
			else draw(N);
			sb.append('\n');			
			
			s = br.readLine();
		} while(s!=null);
		
		System.out.println(sb);

	}

	static void draw(int length) {
		if (length == 1) {
			sb.append('-').append(' ').append('-');
		} else {

			draw(length - 1);
			for (int i = 0; i < Math.pow(3, length - 1); i++) {
				sb.append(' ');
			}
			draw(length - 1);
		}
	}

}
