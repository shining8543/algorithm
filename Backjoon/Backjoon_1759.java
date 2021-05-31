
// 백준 1759 암호 만들기
// 주소 : https://www.acmicpc.net/problem/1759


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1759 {
	
	static boolean alphabet[] = new boolean[26];
	static boolean used[] = new boolean[26];	
	static int bit;
	static char yourAlphabet[] = new char[15];
	static char password[] = new char[15];
	static int L,C; //L은 패스워드 길이 , C는 주어진 문자 갯 수
	static int aeiou_cnt;
	static int else_cnt;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int token;
		int cnt=0;
		String s;
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<C;i++) {
			token = (st.nextToken(" ").charAt(0))-'a';
			alphabet[token] = true;
		}
		
		for(int i=0;i<26;i++) {
			if(alphabet[i]) {
				yourAlphabet[cnt++] = (char)(i+'a');
			}
		}
		comb(0,0);
		System.out.println(sb);
	}
	
	static void comb(int idx, int len) {
		

		if(len == L) {	
			if(aeiou_cnt <1 || else_cnt < 2) return;
			for(int i=0;i<L;i++)
				sb.append(password[i]);
			sb.append("\n");
			return;
		} else {	
			if(idx >= C) return;
			password[len] = yourAlphabet[idx];
			if(yourAlphabet[idx]=='a'||yourAlphabet[idx]=='e'||yourAlphabet[idx]=='i'||yourAlphabet[idx]=='o'||yourAlphabet[idx]=='u') {
				aeiou_cnt++;
			} else {
				else_cnt++;
			}
			comb(idx+1,len+1);
			
			if(yourAlphabet[idx]=='a'||yourAlphabet[idx]=='e'||yourAlphabet[idx]=='i'||yourAlphabet[idx]=='o'||yourAlphabet[idx]=='u') {
				aeiou_cnt--;
			} else {
				else_cnt--;
			}
			
			comb(idx+1,len);			
		}
		
		
	}
}
