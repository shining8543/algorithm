
// 백준 2455 지능형 기차
// 주소 : https://www.acmicpc.net/problem/2455

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2455 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result=0;
		int train=0;
		int in, out;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			out = Integer.parseInt(st.nextToken(" "));
			in = Integer.parseInt(st.nextToken(" "));
			train += in - out;
			result = Math.max(result,train);
		}
		System.out.println(result);
	}
}
