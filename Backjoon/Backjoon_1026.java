
// 백준 1026 보물
// 주소 : https://www.acmicpc.net/problem/1026

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		int result = 0;
		List<Integer> A = new ArrayList();
		List<Integer> B = new ArrayList();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A.add(Integer.parseInt(st.nextToken(" ")));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			B.add(Integer.parseInt(st.nextToken(" ")));
		}
		
		Collections.sort(A, (o1,o2)->o1-o2);
		Collections.sort(B, (o1,o2)->o2-o1);
		
		
		for(int i=0;i<N;i++) {
			result += A.get(i) * B.get(i);
		}
		System.out.println(result);
		
	}
}
