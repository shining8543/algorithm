// 백준 2798 블랙잭
// 주소 : https://www.acmicpc.net/problem/2798

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2798 {
	static int card[] = new int[100];
	static int bit[] = new int[100];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int card_cnt;
		int goal_score;
		int result, t_result;
		
		st = new StringTokenizer(br.readLine());
		
		card_cnt = Integer.parseInt(st.nextToken(" "));
		goal_score = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<card_cnt;i++) {
			card[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		for(int i=0;i<3;i++) {
			bit[i] = 1;
		}
		
		result=0;
		t_result=0;
		
		do {
			t_result=0;
			
			for(int i=0;i<card_cnt;i++) 
				if(bit[i]==1) t_result += card[i];					
			
			if(t_result <= goal_score) result = Math.max(result, t_result);
			
		}while(comb(card_cnt));
		
		
		System.out.println(result);
	}
	static boolean comb(int idx) {
		
		int i =0;
		while(i <idx-1 && bit[i] <= bit[i+1])
			i++;
		
		if(i==idx-1)
			return false;
		
		int j=0;
		
		while(bit[j] <= bit[i+1])
			j++;
		swap(i+1,j);
		
		
		int k = 0;
		
		while(k < i) {
			swap(k++,i--);
		}
		
		return true;
	}
	static void swap(int i, int j) {
		int temp = bit[i];
		bit[i] = bit[j];
		bit[j] = temp;
	}
	
	
}
