// 백준 1987 알파벳
// 주소 : https://www.acmicpc.net/problem/1987

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1987 {
	
	static char map[][] = new char[20][20];
	static boolean alphabet[] = new boolean[26];
	static boolean visit[][] = new boolean[20][20];
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	static int alp_cnt;
	static int R,C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int bit;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		String s;
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);				
			}
		}
	
	
		alphabet[map[0][0] -'A'] = true;
		seek(1,0,0);
		System.out.println(alp_cnt);
		
		
	}
	static void seek(int cnt, int i,int j) {
		int x,y;
		int idx;
		alp_cnt = Math.max(alp_cnt, cnt);
		
		visit[i][j] = true;
		
		
		for(int d=0;d<4;d++) {
			x = i + ni[d];
			y = j + nj[d];
			
			if(x < 0 || y < 0 || x >= R || y >=C || visit[x][y]|| alphabet[map[x][y]-'A']) continue;
			
			
			visit[x][y] = true;
			alphabet[map[x][y]-'A'] = true;
			seek(cnt+1,x,y);
			alphabet[map[x][y]-'A'] = false;
			visit[x][y] = false;
			
		}
		
	}
	
	
}
