import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_1464_DFS {
	static int result;
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
		
		
		int num;
		int time;
		result = Integer.MAX_VALUE;
		DFS(N,0);
		System.out.println(result);
		
		
	}
	
	static void DFS(int num, int time) {
		
		if(num==1) {
			result = time;
		}
		
		if(result<=time) {
			return;
		}
		
		if(num%3==0 && num/3 > 0) DFS(num/3, time+1);
		if(num%2==0 && num/2 > 0) DFS(num/2, time+1);
		if(num>1) DFS(num-1,time+1);
		
		
	}
	
}
