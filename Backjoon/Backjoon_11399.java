import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 11399 ATM
// 주소 : https://www.acmicpc.net/problem/11399


public class Backjoon_11399 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int len;
		int num;
		int result = 0;
		
		len = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[len];
		
		for(int i=0;i<len;i++) {
			num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		
	
		Arrays.sort(arr);
		for(int i=0;i<len;i++) {
			result += arr[i] * (len-i);
		}
		
		
		System.out.println(result);
		
	}
}
