import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2810 컵 홀더
// 주소 : https://www.acmicpc.net/problem/2810
public class Backjoon_2810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int len;
		st = new StringTokenizer(br.readLine());
		len = Integer.parseInt(st.nextToken());
		int s_count=0;
		int l_count=0;
		
		st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		int result=1;
		for(int i=0;i<len;i++) {
			if(s.charAt(i) == 'S') {
				s_count++;
			}
			else {
				l_count++;
			}
		}
		result = 1 + s_count + l_count / 2 ;
        if(result > len) result = len;
		System.out.println(result);
		
	}
}
