import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2999 비밀 이메일
// 주소 : https://www.acmicpc.net/problem/2999


public class Backjoon_2999 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char[][] arr = new char[100][100];
		int x=0,y=0;
		int t_x=0, t_y=0;
		
		String s;
		s = br.readLine();
		
		for(int i=1;i<=s.length()/2;i++) {
			if((s.length()%i)==0) {
				t_x= i;
				t_y = s.length()/t_x;
				if(t_x <= t_y) {
					x = t_x;
					y = t_y;
				}
			}
		}
		
		//System.out.println(x+" "+y);
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				arr[i][j] = s.charAt(x*j+i);
			}
		}
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(arr[i][j]);
			}
		}
		
	}

}
