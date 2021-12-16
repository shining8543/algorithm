import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2166 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N  = Integer.parseInt(br.readLine());
		
		long[] x = new long[N];
		long[] y = new long[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken(" "));
			y[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		long num = 0;
		for(int i=1;i<N-1;i++) {
			num += (x[0] * y[i]  + x[i] * y[i+1] + x[i+1] * y[0]) - (x[0] * y[i+1] + x[i] * y[0] + x[i+1]* y[i]);
		}
		
		num = Math.abs(num);
		
		System.out.printf("%.1f",(double)num/2);
		
	}
}
