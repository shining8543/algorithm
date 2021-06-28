
 // 백준 14889 스타트와 링크
 // 주소 : https://www.acmicpc.net/problem/14889


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14889 {
	
	static int arr[][] = new int[20][20];
	static int N;
	static int result;
	static int bit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		result = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j=0;j<N;j++) {				
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		bit = 0 << N+1;
		comb(0,0);
		System.out.println(result);
		
		
		
	}
	
	static void comb(int idx,int cnt) {
		
		if(cnt==N/2) {
			int start_team=0;
			int link_team=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j) continue;					
					if((bit&1 << i)!=0 && (bit & 1 << j)!=0) {						
						start_team += arr[i][j];
					}else if((bit&1 << i)==0 && (bit & 1 << j)==0) {
						link_team += arr[i][j];
					}
				}
			}
			result = Math.min(result, Math.abs(start_team - link_team));
			
			
			return;
		} else {
			if(idx!=N) {
				bit = bit | 1 << idx;
				comb(idx+1,cnt+1);
				
				
				bit = bit & ~(1 << idx);
				comb(idx+1,cnt);
				
				
			}			
		}
		
	}
	
}
