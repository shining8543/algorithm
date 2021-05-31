
// 백준 2578 빙고
// 주소 : https://www.acmicpc.net/problem/2578

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2578 {
	static public class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int bingo_cnt = 0;
		int num;
		Node[] bingo = new Node[26]; // 숫자 빙고판 위치 저장
		int[] row = new int[6];
		int[] col = new int[6];
		int right_diagnoal = 0;
		int left_diagnoal = 0;
		boolean isFinish =false;
		int x,y;

		for (int i = 1; i <= 5; i++) { // 빙고 입력
			st = new StringTokenizer(br.readLine());
			row[i] = 0;
			col[i] = 0;

			for (int j = 1; j <= 5; j++) {
				num = Integer.parseInt(st.nextToken(" "));
				bingo[num] = new Node(i, j);

			}
		}

		for (int i = 0; i < 5 && !isFinish; i++) { // 사회자 번호 확인
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				num = Integer.parseInt(st.nextToken(" "));
				x = bingo[num].i;
				y = bingo[num].j;
				row[x]++;
				col[y]++;
				if(x==y) {
					right_diagnoal++;
					if(right_diagnoal==5) bingo_cnt++;
				}
				if(x+y ==6) {
					left_diagnoal++;
					if(left_diagnoal==5) bingo_cnt++;
				}
				if(row[x] == 5)bingo_cnt++;
				if(col[y] ==5) bingo_cnt++;
				
				if(bingo_cnt >=3) {
					//System.out.println(num);
					System.out.println(i*5 + j);
					isFinish = true;
					break;
				}
			}

		}

	}
}
