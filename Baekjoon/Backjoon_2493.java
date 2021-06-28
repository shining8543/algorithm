// 백준 2494 탑
// 주소 : https://www.acmicpc.net/problem/2493


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int len;
		st = new StringTokenizer(br.readLine());
		
		len = Integer.parseInt(st.nextToken());
		
		int[] num_stack = new int[500002];
		int[] idx_stack = new int[500002];
		int[] result = new int[500002];
		int stack_cnt=1;
		int stack_num, num;
		
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		
		num_stack[stack_cnt] = num;
		idx_stack[stack_cnt++] = 1;
		result[1] = 0;
		sb.append(result[1]);
		sb.append(" ");
	
		for(int i=2; i<=len; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num_stack[stack_cnt-1] > num) {
				result[i] = idx_stack[stack_cnt-1];
				num_stack[stack_cnt] = num;
				idx_stack[stack_cnt++] = i;
			}
			else {
				while(true) {
					stack_cnt--;
					if(stack_cnt == 1) { //스택이 빌 때까지 확인했는데 없다면 지금 숫자를 스택에 넣어준다.
						num_stack[stack_cnt] = num;
						idx_stack[stack_cnt++] = i;
						result[i] = 0;
						break;
					}else if(num_stack[stack_cnt-1] > num) {
						result[i] = idx_stack[stack_cnt-1];
						num_stack[stack_cnt] = num;
						idx_stack[stack_cnt++] = i;
						break;
					}						
					
					
				}
			}
						
			sb.append(result[i]);
			sb.append(" ");
			
			
		}
		
		System.out.println(sb);
		
		
	}
}
