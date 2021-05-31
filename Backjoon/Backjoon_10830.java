
// 백준 10830 행렬 제곱
// 주소 : https://www.acmicpc.net/problem/10830

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_10830 {
	static long arr[][] = new long[5][5]; //입력값이 최대 1000억 이므로 long으로 선언
	static long result[][] = new long[5][5];
	static long N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		long M;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Long.parseLong(st.nextToken(" "));
		

		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Long.parseLong(st.nextToken(" "));			
			}
			result[i][i] =1; 
		}
		//입력 끝
		
		result = matrix_square(result,arr,M);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

		
	}
	//A^6 = A*A*A*A*A*A = A^3 * A^3 = A * A^2 * A * A^2 
	static long[][] matrix_square(long arr1[][] ,long arr2[][],long M) {
		
		// 시간 복잡도를 O(n)에서 O(log n)으로 하기 위해 분할
		
		long temp[][] = new long[5][5];
		if(M==1) { //더 이상 나눌 수 없으면 행렬 곱셈 계산 : arr1 * arr2 를 반환
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0; k<N;k++) {
						temp[i][j] += arr1[i][k]*arr2[k][j];
					}
					temp[i][j] %= 1000;
				}
			}
			return temp;			
		}
		
		// 제곱이 짝수번 남은 경우 A^x = A^(x/2) * A^(x/2)로 변경
		else if (M % 2 == 0) {
			temp = matrix_square(arr1,arr2,M/2);
			temp = matrix_square(temp,temp,1);
		}
		//제곱이 홀수번 남은 경우 A^x = A * A^(x/2) * A^(x/2)로 변경
		else if (M % 2 == 1) {
			temp = matrix_square(arr1,arr2,M/2);
			temp = matrix_square(temp,temp,1);
			temp = matrix_square(arr,temp,1);
		}
		return temp;

	}

}
