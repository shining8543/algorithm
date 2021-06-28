import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_9661 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long num;
		
		st = new StringTokenizer(br.readLine());
		num = Long.parseLong(st.nextToken(" "));
		
		if(num % 5 == 0 || num % 5 == 2)
			System.out.println("CY");
		else
			System.out.println("SK");
		
//		boolean dp[] = new boolean[300];
//		dp[0] = false;
//		dp[1] = true;
//		
//		for(int i=0;i<200;i++) {
//			int j=1;
//			while(j<i) {
//				if(dp[i-j]==false) {
//					dp[i] = true;
//					break;
//				}
//				j *= 4;
//			}
//		}
//		
//		for(int i=0;i<200;i++) {
//			if(dp[i]) System.out.print("O ");
//			else System.out.print("X ");
//		}
			
		
		
	}
}
