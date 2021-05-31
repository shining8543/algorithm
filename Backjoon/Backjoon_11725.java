
// 백준 11725 트리의 부모 찾기
// 주소 : https://www.acmicpc.net/problem/11725

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_11725 {
	
	static int N;
	static List<Integer> list[] = new ArrayList[100001];
	static boolean[] visit = new boolean[100001];
	static int parent[] = new int[100001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n1,n2;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken(" "));
			n2 = Integer.parseInt(st.nextToken(" "));
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		for(int i=1;i<=N;i++)
			dfs(i);
		
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=N;i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	static void dfs(int num) {
		if(visit[num]) return;
		visit[num] = true;
		
		for(int n : list[num]) {
			if(!visit[n]) {
				parent[n] = num;
				dfs(n);				
			}			
		}
		
		
	}
}
