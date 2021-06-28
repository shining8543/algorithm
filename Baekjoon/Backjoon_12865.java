
// 백준 12865 평범한 배낭
// 주소 : https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_12865 {
	static class Node {
		int w, v;

		Node() {
		}

		Node(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N, K;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" ")); // 아이템 종류
		K = Integer.parseInt(st.nextToken(" ")); // 제한 무게
		Node item[] = new Node[N+1];
		int bag[][] = new int[N+1][K+1]; 
		int w, v;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken(" "));
			v = Integer.parseInt(st.nextToken(" "));

			item[i] = new Node(w, v);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				bag[i][j] = Math.max(bag[i][j-1], bag[i-1][j]);
				if(item[i].w <= j) {
					bag[i][j] = Math.max(bag[i][j], item[i].v + bag[i-1][j-item[i].w]);				
				}
				//System.out.print(bag[i][j]+" ");
			}
		//	System.out.println();
		}
		System.out.println(bag[N][K]);

	}
}
