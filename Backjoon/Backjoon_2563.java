import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2563 {
	static 	int[][] arr = new int[101][101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result=0;
	
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x,y;
		
		for(int k=0;k<n;k++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken(" "));
			y = Integer.parseInt(st.nextToken(" "));
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					arr[i][j] = 1;
				}
			}		
			
		}
		
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				if(arr[i][j] ==1 ) result++;
			}
		}
		
		System.out.println(result);
	}
}

