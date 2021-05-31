
// 백준 2559 수열
// 주소 : https://www.acmicpc.net/problem/2559


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N,K;
		int arr[] = new int[100000];
		int result = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<K;i++)
			sum += arr[i];
		
		result =sum;
		
		for(int i=1;i<=N-K;i++) {
			sum =sum - arr[i-1] + arr[i+K-1];
			result = Math.max(sum, result);
		}
		
		System.out.println(result);
	}
}
