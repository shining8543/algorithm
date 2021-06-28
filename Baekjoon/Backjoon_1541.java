import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		int num1,num2;
		int now_num=0;
		boolean minus = false;
		st = new StringTokenizer(br.readLine());
		s = st.nextToken();
		
		num1=0;
		num2=0;
		
		int len = s.length();
		for(int i=0;i<len;i++) {
			if(s.charAt(i)=='+') {
				if(minus) 
					num2+=now_num;
				
				else 
					num1+=now_num;	
				
				now_num=0;
				
			}else if(s.charAt(i)=='-') {
				if(minus) {
					num2+=now_num;
				}
				else
					num1+=now_num;
				
				now_num=0;				
				minus = true;
			}
			else {
				now_num = now_num*10 + (s.charAt(i)-'0');
			}
		}
		
		if(minus) num2 += now_num;
		else num1 += now_num;
		
		System.out.println(num1-num2);
		
		
	}
}
