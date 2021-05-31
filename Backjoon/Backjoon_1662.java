import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Backjoon_1662 {

	static String comp_s;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int len;

		st = new StringTokenizer(br.readLine());

		comp_s = st.nextToken();
		
	
		
		len = decompress();
	//	
		System.out.println(len);

	}

	static int decompress() {
		
		String s = "";
		String sub_s;
		
		int len=0;
		int sub_len=0;
		
		int num;
		
		
		while (idx < comp_s.length()) {
			if (comp_s.charAt(idx) == '(') {
				num = Integer.parseInt(comp_s.substring(idx-1, idx));
				len--;
				idx++;
				sub_len = decompress();
				len += sub_len*num;
				
				
				
			} else if (comp_s.charAt(idx) == ')') {
				idx++;
				return len;
			}else {
				len++;			
				idx++;
			}			
			
		}
		return len;
	}

}
