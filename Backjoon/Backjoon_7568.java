
// 백준 7568 덩치
// 주소 : https://www.acmicpc.net/problem/7568

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_7568 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int weight[] = new int[50];
		int height[] = new int[50];

		int num=0;
		int cnt;
		try {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken(" "));

			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken(" "));
				height[i] = Integer.parseInt(st.nextToken(" "));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//입력 끝
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<num;i++) {
			cnt=1;
			for(int j=0;j<num;j++) {
				if(weight[j]>weight[i] && height[j] > height[i])
					cnt++;
			}
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);

	}
}
