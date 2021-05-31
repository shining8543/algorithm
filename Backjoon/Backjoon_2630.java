
// 백준 2630 색종이 만들기
// 주소 : https://www.acmicpc.net/problem/2630

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2630 {
	static int arr[][] = new int[128][128];
	static int paper[] = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int length;
		
		st = new StringTokenizer(br.readLine());
		length = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<length;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		cut(0,0,length);
		
		System.out.println(paper[0]);
		System.out.println(paper[1]);
		
		
	}
	
	static void cut(int i_idx,int j_idx,int length) {
		if(length==1) {
			paper[arr[i_idx][j_idx]]++;
			
		} else {
			if(isSame(i_idx,j_idx,length)) {				
				paper[arr[i_idx][j_idx]]++;
			}
			else {
				cut(i_idx,j_idx,length/2);
				cut(i_idx,j_idx+length/2,length/2);
				cut(i_idx+length/2,j_idx,length/2);
				cut(i_idx+length/2,j_idx+length/2,length/2);
			}
			
			
		}
		
	}
	
	static boolean isSame(int i_idx,int j_idx,int length) {
		
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(arr[i_idx][j_idx]!=arr[i_idx+i][j_idx+j]) {
					return false;
				}
				
			}
		}
		
		
		
		return true;
	}
	
}
