import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_8985 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		int o_count;
		int result;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k=0;k<t;k++) {
			o_count = 0;
			result = 0;
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='O') {
					o_count++;
					result += o_count;					
				} else {
					o_count = 0;
				}
				
			}
			System.out.println(result);
			
		}
		
	}
}
