import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Character> stack = new Stack();
		String s;
		char token;
		
		StringBuilder sb = new StringBuilder();
		
		
		s = br.readLine();
		
		
		for(int i=0;i<s.length();i++) {
			token = s.charAt(i);
			if(token == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append('<');
				while(token !='>') {					
					token = s.charAt(++i);
					sb.append(token);
				}
			} else if(token ==' '){
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			} else {
				stack.push(token);				
			}			
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
		
	}
}
