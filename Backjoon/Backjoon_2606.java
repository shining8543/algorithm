
// 백준 2606 바이러스
// 주소 : https://www.acmicpc.net/problem/2606


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2606 {
	
	static int N;
	static int M;
	static int result;
	static boolean pair[][] = new boolean[101][101];
	static boolean visit[] = new boolean[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		
		int num1,num2;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken(" "));
			num2 = Integer.parseInt(st.nextToken(" "));
			
			pair[num1][num2] = true;
			pair[num2][num1] = true;
			
		}
		visit[1]=true;
		virus(1);
		System.out.println(result);
		
		
	}
	
	static void virus(int idx) {
		for(int i=1;i<=N;i++) {
			if(visit[i]) continue;
			
			if(pair[idx][i]) {
				visit[i]= true;
				result++;
				virus(i);
			}
			
		}
		
		
	}
	
}
