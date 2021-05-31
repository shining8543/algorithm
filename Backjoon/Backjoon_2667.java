
// 백준 2667 단지번호붙이기
// 주소 : https://www.acmicpc.net/problem/14719

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2667 {
	static class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static Queue<Node> q = new LinkedList();
	static int N;
	static int arr[][];
	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j)-'0';
				if (arr[i][j] == 1)
					q.add(new Node(i, j));
			}
		}
		BFS();

	}

	static void BFS() {
		int x, y;
		boolean visit[][] = new boolean[N][N];
		Queue<Node> nq = new LinkedList();
		List<Integer> cnt_list = new ArrayList();
		Node node;
		int cnt;
		while (!q.isEmpty()) {
			node = q.poll();
			if (visit[node.i][node.j])
				continue;
			visit[node.i][node.j] = true;
			cnt = 1;
			nq.add(node);
			while (!nq.isEmpty()) {
				node = nq.poll();
				for (int d = 0; d < 4; d++) {
					x = node.i + ni[d];
					y = node.j + nj[d];
					if(x < 0 || y<0 || x>=N || y>=N || arr[x][y]==0 || visit[x][y]) continue;
					
					visit[x][y] = true;
					cnt++;
					nq.add(new Node(x,y));
					
					
				}
			}
			cnt_list.add(cnt);
			//System.out.println(cnt);
		}

		Collections.sort(cnt_list);
		System.out.println(cnt_list.size());
		for(int result : cnt_list)
			System.out.println(result);
	}

}
