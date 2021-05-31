
// 백준 2447 별 찍기
// 주소 : https://www.acmicpc.net/problem/2447

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon_2447 {

	static char map[][] = new char[2187][2187];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int size;

		st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken(" "));
 
		// ***   123
		// * *	 456 
		// ***   789
	
		
		star_fill(0, 0, size);
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}
		System.out.print(sb);
		

		
		
	}

	private static void star_fill(int i_start, int j_start, int length) {
		if (length <= 3) {
			
			for(int i=0;i<length;i++) {
				for(int j=0;j<length;j++) {
					map[i+i_start][j+j_start] = '*';
				}
			}
			map[i_start+1][j_start+1] =' ';
			
			
		} else {

			// start_fill을 8번 호출 가운데는 다 공백 때려박기

			//  좌상중상 우상
			star_fill(i_start, j_start, length / 3);
			star_fill(i_start, j_start + length / 3, length / 3);
			star_fill(i_start, j_start + 2 * length / 3, length / 3);

			// 좌중 우중
			star_fill(i_start + length / 3, j_start, length / 3);
			star_fill(i_start + length / 3, j_start + 2 * length / 3, length / 3);

			// 좌하 중하 우하 우하 하게 만들어줘
			star_fill(i_start + 2 * length / 3, j_start, length / 3);
			star_fill(i_start + 2 * length / 3, j_start + length / 3, length / 3);
			star_fill(i_start + 2 * length / 3, j_start + 2 * length / 3, length / 3);

			// 가운데 공백 채우기
			for (int i = 0; i < length / 3; i++) {
				for (int j = 0; j < length / 3; j++) {
					map[i_start + i + length / 3][j_start + j + length / 3] = ' ';
				}
			}

		}

	}

}
