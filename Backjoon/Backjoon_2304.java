
// 백준 2304 창고 다각형
// 주소 : https://www.acmicpc.net/problem/2304

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2304 {
	static int height[] = new int[10000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		int num, result=0;
		int pos;
		int max_height = 0;
		int max_pos = Integer.MAX_VALUE;
		int now_height = 0;
		int now_pos =0;
		int start_idx=Integer.MAX_VALUE, end_idx=Integer.MIN_VALUE;
		
		
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			pos = Integer.parseInt(st.nextToken(" "));
			start_idx = Math.min(start_idx, pos);
			end_idx = Math.max(end_idx, pos);
			height[pos] = Integer.parseInt(st.nextToken(" "));
			if((max_height == height[pos])&& max_pos > pos )max_pos = pos;
			else if(max_height < height[pos]) {
				max_pos = pos;
				max_height = height[pos];
				
			}
		}
		
		int idx=start_idx;
		while(idx <= end_idx) {
			result += now_height;
			now_height = Math.max(now_height, height[idx]);
			if(idx == max_pos ) {
				break;
			}
			idx++;
		}
		
		idx = end_idx+1;		
		now_height=height[idx];
		
		while(idx > 1) {
			idx--;			
			now_height = Math.max(now_height, height[idx]);
			result += now_height;
			if(idx == max_pos ) break;
		}
		
		System.out.println(result);
	}	
	
}
