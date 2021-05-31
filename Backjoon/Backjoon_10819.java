
// 백준 10819 차이를 최대로
// 주소 : https://www.acmicpc.net/group/workbook/view/10362/31440
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_10819 {

	static int num[] = new int[8];
	static int arr[] = new int[8];
	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int bit;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		bit = 1 << N;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken(" ")); 
		}
		
		perm(0,bit);
	
		System.out.println(answer);
		
	}
	
	
	static void perm(int cnt, int bit) {
		
		if(cnt==N) {
			int result=0;
			for(int i=0;i<=N-2;i++) {
				result += Math.abs(arr[i]-arr[i+1]); 
				answer = Math.max(answer, result);
			}
			
			
			
		}else {
			for(int i=0;i<N;i++) {
				if((bit & 1 << i)!=0) continue;
				
				arr[cnt] = num[i];
				perm(cnt+1, bit | 1 << i);
				
				
			}
			
			
		}
		
		
	}
}
