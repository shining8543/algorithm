import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2941 {
	static String croatia[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		String s;
		StringBuilder sb = new StringBuilder();
		
		s = br.readLine();
		int cnt =0;
		char token;
		
		for(int i=0;i<s.length();i++) {
			token = s.charAt(i);
			
			if(token == 'c') {
				if(i+1 < s.length() && (s.charAt(i+1)=='='||s.charAt(i+1)=='-')) {
					i++;
				}
			}else if(token =='d') {
				if(i+2< s.length() && s.charAt(i+1) == 'z' && s.charAt(i+2)=='=') {
					i= i+2;
				}
				else if(i+1<s.length() && s.charAt(i+1)=='-') {
					i++;
				}
			} else if(token=='l') {
				if(i+1 < s.length() && s.charAt(i+1) == 'j')
					i++;
			} else if(token=='n') {
				if(i+1 < s.length() && s.charAt(i+1) == 'j')
					i++;
			} else if(token=='s') {
				if(i+1 < s.length() && s.charAt(i+1)=='=')
					i++;
			} else if(token =='z') {
				if(i+1 < s.length() && s.charAt(i+1)=='=')
					i++;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
