// 백준 16918 봄버맨 
// 주소 : https://www.acmicpc.net/problem/16918

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_16918 {
	static public class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	static char arr[][] = new char[200][200]; //0은 초기 1은  폭발 후 2는 결과 넣자
	static int map[][] = new int[200][200];
	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean visit[][];
		
		Queue<Node> first_bomb = new LinkedList();
		Queue<Node> second_bomb = new LinkedList();
		int R, C, N;
		int x,y;
		Node bomb;
		String s;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		N = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'O')
					first_bomb.add(new Node(i,j));
				else {
					second_bomb.add(new Node(i,j));
				}
			}
		}
		//N을 %3해서 1이면 초기 모습 , 3이면 첫 폭발 모습 
		if(N%2==0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++)
					arr[i][j] = 'O';
			}
			
		} else{
						
			if(N==1) {				
								
			}
			else if(N==3) {
				
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++)
						arr[i][j] = 'O';
				}
				while(!first_bomb.isEmpty()) {
					
					bomb = first_bomb.poll();					
					
					arr[bomb.i][bomb.j] = '.';
					
					for(int d=0;d<4;d++) {
						x = bomb.i+ni[d];
						y = bomb.j+nj[d];
						
						if( x< 0 || y< 0 || x>=R || y>=C) continue;
						
						arr[x][y] = '.';
						
					}
					
				}
				
			}else if(N>4) {
				
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++)
						arr[i][j] = 'O';
				}
				
				while(!first_bomb.isEmpty()) {
					
					bomb = first_bomb.poll();					
					
					arr[bomb.i][bomb.j] = '.';
					
					for(int d=0;d<4;d++) {
						x = bomb.i+ni[d];
						y = bomb.j+nj[d];
						
						if( x< 0 || y< 0 || x>=R || y>=C) continue;
						
						arr[x][y] = '.';
						
					}
					
				}
				
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(arr[i][j]=='O') first_bomb.add(new Node(i,j));
					}
				}
				
				
				
				if(N%4==1) {
					for(int i=0;i<R;i++) {
						for(int j=0;j<C;j++)
							arr[i][j] = 'O';
					}
					while(!first_bomb.isEmpty()) {
						
						bomb = first_bomb.poll();					
						
						arr[bomb.i][bomb.j] = '.';
						
						for(int d=0;d<4;d++) {
							x = bomb.i+ni[d];
							y = bomb.j+nj[d];
							
							if( x< 0 || y< 0 || x>=R || y>=C) continue;
							
							arr[x][y] = '.';
							
						}
						
					}
					
					for(int i=0;i<R;i++) {
						for(int j=0;j<C;j++) {
							if(arr[i][j]=='O') first_bomb.add(new Node(i,j));
						}
					}
				}
				else if(N%4==3) {
					
					
				}
				
				
			}
			
			
			
		}

		
		
		

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
}
