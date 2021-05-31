// 백준 1992 쿼드트리
// 주소 : https://www.acmicpc.net/problem/1992

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1992 {
	static StringBuilder sb = new StringBuilder();
	static char[][] bit = new char[65][65];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int bit_size;
		String s;
		
		st = new StringTokenizer(br.readLine());
		bit_size = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<bit_size;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for(int j=0;j<bit_size;j++) {
				bit[i][j] = s.charAt(j);				
			}
			
			
			
			
		}
		divide(0,0,bit_size);
		System.out.println(sb);
		
		
	}
	
	static void divide(int i_start,int j_start,int length) {
		
		
		if(length==1 || isSame(i_start, j_start,length)) {
			sb.append(bit[i_start][j_start]);
			//System.out.println(i_start+" "+j_start+" "+length+" = "+bit[i_start][j_start]);
			//System.out.print(bit[i_start][j_start]);
			
		} else {
			sb.append('(');
			//System.out.print('(');
			divide(i_start,j_start , length/2);
			divide(i_start,j_start+length/2, length/2);
			divide(i_start + length/2 , j_start, length/2);
			divide(i_start + length/2, j_start + length/2 , length/2);
			sb.append(')');
			//System.out.print(')');
		}
		
	}
	
	
	
	static boolean isSame(int i_start, int j_start, int length) {	
		
		char checking_bit = bit[i_start][j_start]; 
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(checking_bit != bit[i+i_start][j_start+j]) {
					return false;
				}
			}
		}
		
		
		
		return true;
	}
	
	
}
