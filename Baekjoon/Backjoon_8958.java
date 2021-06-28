
// 백준 8958 OX 퀴즈
// 주소 : https://www.acmicpc.net/problem/8958

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case;
		int result;
		int cnt;
		String s;
		st = new StringTokenizer(br.readLine());
		test_case = Integer.parseInt(st.nextToken(" "));

		for (int t = 0; t < test_case; t++) {
			result =0;
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'O') {
					cnt++;
					result +=cnt;
				} else {
					cnt = 0;
				}				

			}
			System.out.println(result);
		}

	}
}
