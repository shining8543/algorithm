// 백준 3109 빵집
// 주소 : https://www.acmicpc.net/problem/3109

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_3109 {

	
	static boolean[][] wall = new boolean[10001][501];
	static int R, C;
	static int result;
	static int ni[] = {-1,0,1};
	static int nj[] = {1,1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));

		String s;
		
		result = 0;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for (int j = 0; j < C; j++) {
				if (s.charAt(j) == '.')
					wall[i][j] = true;

			}
		}

		//위에서부터 들어가는 것이 무조건 최선
		for (int i = 0; i < R; i++) { 
			pipe(i,0);
		}
		

		
		System.out.println(result);
		
	}

	static boolean pipe(int i,int j) {

			
		int x,y;

		

		if(j==C-1) {
			result++;
			return true;
		}
			
			for (int d = 0; d < 3; d++) {
				x = i + ni[d];
				y = j + nj[d];
				
				if(x < 0 || x >= R || y >=C || !wall[x][y]) continue;
				
				wall[i][j] = false; //지금 가는 애가 못가면 어차피 뒤에서도 못 가니깐 다시 true 할 필요 없음(가지치기)
				if(pipe(x,y)) {
					return true;
				}
						
			}
			
		return false;
		
		}

	}


