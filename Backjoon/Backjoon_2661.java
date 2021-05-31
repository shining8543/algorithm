
// 백준 2661 좋은 수열
// 주소 : https://www.acmicpc.net/problem/2661


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2661 {
	static boolean isFinish = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		String s = "";	
		make_good(N,0,s);
		//System.out.println(isGood(s));
	}
	
	
	static void make_good(int N,int len, String s) {
		if(isFinish) return;
		if(len==N) {
			System.out.println(s);
			isFinish = true;
			return;
		}
		
		for(int i=1;i<=3;i++) {
			if(isGood(s+i)) {
				make_good(N,len+1,s+i);
			}			
		}
	}
	
	

	static boolean isGood(String s) {
		String s1, s2;
		int end_idx = s.length();
		
		for (int l = 1; l <= s.length()/2; l++) {
			
			s1 = s.substring(end_idx-l, s.length());
			s2 = s.substring(end_idx-2*l,end_idx-l);
			if(s1.equals(s2)) return false;

		}

		return true;
	}
}
