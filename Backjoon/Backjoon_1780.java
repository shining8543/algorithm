
// 백준 1780 종이의 개수
// 주소 : https://www.acmicpc.net/problem/1780


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1780 {
	
	static int arr[][] = new int[2187][2187];
	static int paper_cnt[] = new int[3]; // -1,0,1
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		int num;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
	
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		divide(0,0,N);
		
		for(int i=0;i<3;i++)
			System.out.println(paper_cnt[i]);
		
	}
	
	static void divide(int idx_i,int idx_j,int N) {
		
		if(isSame(idx_i,idx_j,N)) {
			paper_cnt[arr[idx_i][idx_j]+1]++;			
		} else {
			
			if(N<=3) {
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						paper_cnt[arr[idx_i+i][idx_j+j]+1]++;
					}
				}				
			} else {
				
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(isSame(idx_i+(i*(N/3)),idx_j+(j*(N/3)),N/3)) {
							paper_cnt[arr[idx_i+(i*(N/3))][idx_j+(j*(N/3))]+1]++;
						}
						else divide(idx_i+(i*(N/3)),idx_j+(j*(N/3)),N/3);
					}
				}
				
				
			}
			
			
			
		}
		
		
		
		
	}
	
	static boolean isSame(int i_start,int j_start, int length) {
		
		int check = arr[i_start][j_start];
		
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(check!=arr[i_start+i][j_start+j]) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	
}
