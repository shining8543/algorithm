
// 백준 1592 영식이와 친구들
// 주소 : https://www.acmicpc.net/problem/1592

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1592 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int L,M,N;
		int[] cnt = new int[1001];
		int num=0;
		int throw_cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		L = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<N;i++)
			cnt[i] = 0;
		
		
		while(true) {
			cnt[num]++;
			if(cnt[num]==M) break;
			
			num = (num + ( N - L )) % N;
			throw_cnt++;
			
		}
		System.out.println(throw_cnt);
		
	}
}
