
// 백준 2605 줄 세우기
// 주소 : https://www.acmicpc.net/problem/2605

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



public class Backjoon_2605 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> line = new Stack();
		Stack<Integer> result = new Stack();
		
		int num;
		int jump;
		
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=num;i++){
			jump = Integer.parseInt(st.nextToken(" "));
			
			for(int j=0;j<jump;j++) {
				if(!line.isEmpty())
					result.add(line.pop());
			}
			
			line.push(i);
			
			while(!result.isEmpty()) {
				line.push(result.pop());
			}
						
		}
		
		while(!line.isEmpty())
			result.push(line.pop());
		
		while(!result.isEmpty()) {
			sb.append(result.pop());
			sb.append(" ");
		}
		
		System.out.println(sb);
	}
}
