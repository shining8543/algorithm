import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_11062 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case;
		st = new StringTokenizer(br.readLine());
		test_case = Integer.parseInt(st.nextToken(" "));
		
		StringBuilder sb = new StringBuilder();
		
		int arr[];
		int first[][] ,second[][];
		
		int N;
		int sum;
		
		
		for(int t=1;t<=test_case;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken(" "));
			
			arr = new int[N];
			first = new int[N+1][N];
			second = new int[N+1][N];
			sum = 0;
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken(" "));
				sum += arr[i];
			}
			
			for(int j=0;j<N;j++) {
				first[0][j] = 0;
				second[0][j] = 0;
			}
			
			for(int j=0;j<N;j++) {
				first[1][j] = arr[j];
				second[1][j] = 0;
			}
			
			
			for(int i=2;i<=N;i++) {
				for(int j=0;j<=N-i;j++) {
					first[i][j] = Math.max(arr[j+i-1]+second[i-1][j], arr[j]+second[i-1][j+1]);
					second[i][j] = Math.min(first[i-1][j], first[i-1][j+1]);
				}
			}
			sb.append(first[N][0]).append('\n');
			
		}
		System.out.println(sb);
		
	}
}
