
// 백준 17281 야구
// 주소 : https://www.acmicpc.net/problem/17281

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17281 {

	static boolean[] visit = new boolean[10]; // 순서 선택 시 출장 여부
	static int[] player = new int[10]; // 출장 순서 플레이어 번호 저장
	static int round; // 이닝 수
	static int[][] player_stat = new int[50][10];
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		round = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < round; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				player_stat[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		} // 선수들 경기력 입력
			// 0 : 아웃 , 1:안타 , 2:2루타 , 3:3루타 , 4:홈런
		perm(1);
		System.out.println(result);
	}

	static void perm(int idx) {
		if (idx == 4) {
			perm(idx + 1);
			return;
		}

		if (idx == 10) {
			player[4] = 1;
			play_ball();
		}

		for (int i = 2; i <= 9; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			player[idx] = i;
			perm(idx + 1);
			visit[i] = false;
		}
	}

	static void play_ball() {
		int playing_num; // 경기 중인 선수 순서
		int idx = 1;
		int out = 0;
		int score = 0;
		int[] base = new int[4];
		
		for (int i = 0; i < round; i++) {
			base[1] = 0; base[2] = 0; base[3] = 0; out=0;
			while (true) {
				playing_num = player[idx];
				switch (player_stat[i][playing_num]) {
				case 0:
					out++;
					break;
					
				case 1:
					score +=base[3];
					base[3] = base[2];
					base[2] = base[1];
					base[1] = 1;
					break;					
				case 2:
					score += base[3]+base[2];
					base[3] = base[1];
					base[2] = 1;
					base[1] = 0;
					break;
					
				case 3:
					score += base[3] + base[2] + base[1];
					base[3] = 1;
					base[2] = 0;
					base[1] = 0;
					break;
					
				case 4:
					score += base[3]+base[2]+base[1]+1;
					base[3] = 0;
					base[2] = 0;
					base[1] = 0;
					break;
					
				default:
					break;				

				}
				idx = idx%9 +1;
				if(out == 3) break;
				
			}

		} //for-end
		result = Math.max(result, score);

	}

}
