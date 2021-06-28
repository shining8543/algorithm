// 백준 10026 적록색약
// 주소 : https://www.acmicpc.net/problem/10026

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_10026 {

	static public class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	static int N; // 크기 1 <= N <= 100
	static char arr[][] = new char[100][100];

	static int normal_cnt;
	static int blind_cnt;
	static boolean check[][] = new boolean[100][100];
	static boolean blind_check[][] = new boolean[100][100];
	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		RGBcount();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='G') arr[i][j]='R';
			}
		}
		
		blindcount();
		System.out.println(normal_cnt + " " + blind_cnt);

	}

	static void RGBcount() {
		Node now;
		int x,y;
		Queue<Node> queue = new LinkedList();
		Stack<Node> stack = new Stack();
		char now_color;
		
		
		queue.add(new Node(0,0));
		
		while(!queue.isEmpty()) {			
			now = queue.poll();
			if(check[now.i][now.j]) continue;			
			
			check[now.i][now.j]= true; 
			stack.add(now);
			normal_cnt++;
			now_color = arr[now.i][now.j];
			
			while(!stack.isEmpty()) {
				now = stack.pop();
				
				
				for(int d=0;d<4;d++) {
					x = now.i+ni[d];
					y = now.j+nj[d];
					
					if(x<0 || y<0 || x>=N || y>=N || check[x][y]) continue;
					
					if(now_color != arr[x][y]) queue.add(new Node(x,y));
					else {
						stack.add(new Node(x,y));
						check[x][y] = true;
					}
					
				}				
			}
			
		}
		
		
		
	}
	
	static void blindcount() {
		Node now;
		int x,y;
		Queue<Node> queue = new LinkedList();
		Stack<Node> stack = new Stack();
		char now_color;
		
		
		queue.add(new Node(0,0));
		
		while(!queue.isEmpty()) {			
			now = queue.poll();
			if(blind_check[now.i][now.j]) continue;			
			
			blind_check[now.i][now.j]= true; 
			stack.add(now);
			blind_cnt++;
			now_color = arr[now.i][now.j];
			
			while(!stack.isEmpty()) {
				now = stack.pop();
				
				
				for(int d=0;d<4;d++) {
					x = now.i+ni[d];
					y = now.j+nj[d];
					
					if(x<0 || y<0 || x>=N || y>=N || blind_check[x][y]) continue;
					
					if(now_color != arr[x][y]) queue.add(new Node(x,y));
					else {
						stack.add(new Node(x,y));
						blind_check[x][y] = true;
					}
					
				}				
			}
			
		}

	}

}
