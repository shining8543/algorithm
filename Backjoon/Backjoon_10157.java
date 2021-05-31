
// 백준 10157 자리배정
// 주소 : https://www.acmicpc.net/problem/10157

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_10157 {
	static int arr[][] = new int[1001][1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int C, R; // 가로 세로
		int obj;
		st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken(" "));
		R = Integer.parseInt(st.nextToken(" "));

		st = new StringTokenizer(br.readLine());
		obj = Integer.parseInt(st.nextToken(" "));

		seek(C, R, obj);
		
//		for(int i=R;i>=1;i--) {
//			for(int j=1;j<=C;j++) {
//				System.out.printf("%4d",arr[i][j]);
//			}
//			System.out.println();
//		}
	}

	static void seek(int C, int R, int obj) {
		
		int delta=1;
		int i=0,j=1;
		int num=1;
		
		int i_length = R;
		int j_length = C;
		
		
		if (obj > C * R) {
			System.out.println("0");
			return;
		}
		
		while(true) {
			for(int y=1;y<=i_length;y++) {
				i+=delta;
				arr[i][j] =num;
				if(num == obj) {
					System.out.println(j+" "+i);
					return;
				}
				num++;
			}
			
			i_length--;
			j_length--;
			
			for(int x=1;x<=j_length;x++) {
				j+=delta;
				arr[i][j] = num;
				if(num == obj) {
					System.out.println(j+" "+i);
					return;
				}
				num++;	
			}
			
			delta*=-1;
			
		}
	

	}
}
