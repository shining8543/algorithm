import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1463 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arr[] = new int[1000001];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		int N;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		for(int i=4;i<=N;i++) {
			arr[i] = Integer.MAX_VALUE;
			if(i%2==0) arr[i] = Math.min(arr[i], arr[i/2]);
			if(i%3==0) arr[i] = Math.min(arr[i], arr[i/3]);
			arr[i] = Math.min(arr[i], arr[i-1]);
			arr[i]++;
		}
		System.out.println(arr[N]);
	}
}
