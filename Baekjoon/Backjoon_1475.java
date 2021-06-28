
// 백준 1475 방 번호
// 주소 : https://www.acmicpc.net/problem/1475

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1475 {

	static int num_cnt[] = new int[10];

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = 0;
		int token;
		int max_cnt=0;

		try {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken(" "));

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (num == 0) {
			num_cnt[0] = 1;
			System.out.println(1);
		}
		else {
			while (num > 0) {

				token = num % 10;
				num_cnt[token]++;
				num /= 10;
			}
			num_cnt[6] += num_cnt[9];
			num_cnt[6] = num_cnt[6] - num_cnt[6]/2;
			
			for(int i=0;i<=8;i++) {
				max_cnt = Math.max(max_cnt,num_cnt[i]);
				
			}
			System.out.println(max_cnt);
			
		}
	}
}
