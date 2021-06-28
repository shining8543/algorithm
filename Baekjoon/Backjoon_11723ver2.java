
// 백준 11723 집합
// 주소 : https://www.acmicpc.net/problem/11723

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_11723ver2 {
	static boolean[] bit = new boolean[21];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int M;
		String s;
		int num;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			s = st.nextToken(" ");

			switch (s) {
			case "add":
				num = Integer.parseInt(st.nextToken(" "));
				bit[num] = true;
				break;
			case "check":
				num = Integer.parseInt(st.nextToken(" "));
				if(bit[num]) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
				
			case "toggle":
				num = Integer.parseInt(st.nextToken(" "));
				bit[num] = !bit[num];
				break;
				
			case "remove":
				num = Integer.parseInt(st.nextToken(" "));
				bit[num] = false;
				break;
				
			case "empty":
				for(int b=1;b<=20;b++) {
					bit[b] = false;
				}
				break;
				
			case "all":
				for(int b=1;b<=20;b++) {
					bit[b] = true;
				}
				break;

			}

		}
		System.out.println(sb);
	}
}
