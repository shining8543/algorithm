import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t;
		long x,y;
		
		t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Long.parseLong(st.nextToken(" "));
			y = Long.parseLong(st.nextToken(" "));
			
			
			long distance = y-x;
			int cnt = 0;
			int max = (int)Math.sqrt(distance);
			int square = max * max;
			
			
			if(square == distance) {
				cnt = max * 2 - 1;
			}else if(square + max >= distance ) {
				cnt = max * 2;
			}else {
				cnt = max * 2 + 1;
			}
			
			sb.append(cnt).append('\n');
			
		}
		System.out.println(sb);
		
	}	
	
}
