
// 백준 11723 집합
// 주소 : https://www.acmicpc.net/problem/11723

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_11723 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int M;
		String s;
		int num;
		int bit = 0;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			s = st.nextToken(" ");

			switch (s) {
			case "add":
				num = Integer.parseInt(st.nextToken(" "));
				bit = bit | 1 << num;
				break;
			case "check":
				num = Integer.parseInt(st.nextToken(" "));
				if((bit & 1 << num)!=0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
				
			case "toggle":
				num = Integer.parseInt(st.nextToken(" "));
				bit = bit ^ (1<<num);
				break;
				
			case "remove":
				num = Integer.parseInt(st.nextToken(" "));
				bit = bit & ~(1 << num);
				break;
				
			case "empty":
				bit = 0;
				break;
				
			case "all":
				bit = 0b111111111111111111111;
				break;

			}

		}
		System.out.println(sb);
	}
}
