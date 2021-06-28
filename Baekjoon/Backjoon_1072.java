// 백준 1072
// 주소 : https://www.acmicpc.net/problem/1072

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long X,Y;
		long result=-1;
		st = new StringTokenizer(br.readLine());
		X = Long.parseLong(st.nextToken(" "));
		Y = Long.parseLong(st.nextToken(" "));
		
		long Z = (Y*100) / X ;
		if(Z<99) {
			long low=0, high=X;
			long temp_Z;
			
			while(low<= high) {
				long mid = (low+high) / 2;
				temp_Z = (100* (Y+mid)) / (X+mid);
				if(Z>=temp_Z) {
					result = mid+1;
					low = mid+1;
				}else {
					high = mid-1;
				}
			}						
		}
		System.out.println(result);
	}
}
