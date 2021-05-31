
// 백준 15683 감시
// 주소 : https://www.acmicpc.net/problem/15683

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_15683 {
	static class Node {
		int i, j, type;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

		Node(int i, int j, int type) {
			this.i = i;
			this.j = j;
			this.type = type;
		}
	}

	static int N, M;
	static int arr[][];
	static int empty_cnt;
	static List<Node> cctv_pos = new ArrayList();
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));

		arr = new int[N][M];

		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				if (arr[i][j] == 0)
					empty_cnt++;
				else if (arr[i][j] != 6) {
					cctv_pos.add(new Node(i, j, arr[i][j]));
				}
			}
		}
		DFS(0,empty_cnt);
		System.out.println(result);
	}

	static void DFS(int idx,int cnt) {
		Node node;
		int x,y;
		int up,down,left,right;
		
		
		if(idx==cctv_pos.size()) {
			result = Math.min(result, cnt);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.printf("%4d",arr[i][j]);
				}
				System.out.println();
			}
			System.out.println(cnt+"------------------------");
			return;
		}
		
		node = cctv_pos.get(idx);
		
	
		x = node.i;
		y = node.j;
		switch(node.type) {
		
			case 1:
			
				
				//위
				
				up = cctv_up(x,y);
				DFS(idx+1, cnt-up);
				cctv_up_back(x,y,up);
				
				//아래
				
				
				down = cctv_down(x,y);
				
				DFS(idx+1,cnt-down);
				cctv_down_back(x,y,down);
				
				
				//좌
				
				left = cctv_left(x,y);		
				DFS(idx+1,cnt-left);			
				
				cctv_left_back(x,y,left);
				
				
				//우
				right = cctv_right(x,y);
			
				DFS(idx+1, cnt-right);
				cctv_right_back(x,y,right);
				
				break;
				
				
				
			case 2:
				//상하
				up = cctv_up(x,y);
				down = cctv_down(x,y);
				
				DFS(idx+1,cnt-(up+down));
				
				cctv_up_back(x,y,up);			
				cctv_down_back(x,y,down);
				//좌우
				
				left = cctv_left(x,y);	
				right = cctv_right(x,y);
							
				
				DFS(idx+1, cnt-(left+right));
				
				cctv_left_back(x,y,left);			
				cctv_right_back(x,y,right);
				
				
				break;
				
			case 3:
				//상우
				up = cctv_up(x,y);
				right = cctv_right(x,y);
				
				DFS(idx+1,cnt-(up+right));
				
				cctv_up_back(x,y,up);	
				
				
				//우하
				down = cctv_down(x,y);
				DFS(idx+1,cnt-(right+down));
				cctv_right_back(x,y,right);
				
				//하좌
				left = cctv_left(x,y);		
				DFS(idx+1,cnt-(left+down));			
				cctv_down_back(x,y,down);
				
				//상좌
				
				up = cctv_up(x,y);
				DFS(idx+1,cnt-(up+left));				
				cctv_left_back(x,y,left);	
				cctv_up_back(x,y,up);	
				
				break;
			case 4:
				
				//좌상우
				
				up = cctv_up(x,y);
				right = cctv_right(x,y);
				left = cctv_left(x,y);	
				DFS(idx+1, cnt-(up+left+right));
				
				cctv_left_back(x,y,left);
				
				//상우하
				down = cctv_down(x,y);
				DFS(idx+1,cnt-(up+right+down));				
				cctv_up_back(x,y,up);
				
				//우하좌
				
				left = cctv_left(x,y);	
				DFS(idx+1,cnt-(right+down+left));				
				cctv_right_back(x,y,right);
				
				//하좌상
				
				up = cctv_up(x,y);	
				DFS(idx+1,cnt-(down+left+up));	
				
				cctv_left_back(x,y,left);
				cctv_down_back(x,y,down);
				cctv_up_back(x,y,up);
				
				
				
				break;
				
			case 5:
				up = cctv_up(x,y);
				right = cctv_right(x,y);
				left = cctv_left(x,y);
				down = cctv_down(x,y);
				
				DFS(idx+1,cnt-(up+left+right+down));
				
				cctv_left_back(x,y,left);
				cctv_down_back(x,y,down);
				cctv_up_back(x,y,up);
				cctv_right_back(x,y,right);
				break;
		
		
		
		
		
		
		}
		
		
		
		
	}
	static int cctv_up(int up_x,int up_y) {
		int up=0;
		while(true) {
			up_x -=1;
			
			if(up_x<0 ||arr[up_x][up_y]==6) {
				up_x++;
				break;
			}
			
			if(arr[up_x][up_y]==0) {
				arr[up_x][up_y] = -1;
				up++;
			}				
		}
		
		return up;
	}
	static void cctv_up_back(int up_x,int up_y,int up){		
		while(up!=0) {
			up_x--;
			if(arr[up_x][up_y]==-1) {
				arr[up_x][up_y]=0;
				up--;
			}
		}
	}
	
	static int cctv_down(int x,int y) {
		int len=0;
		while(true) {
			x += 1;
			if( x>= N || arr[x][y]==6) {
				x--;
				break;
			}
			
			if(arr[x][y]==0) {
				arr[x][y]=-2;
				len++;
			}
		}
		return len;
	}
	static void cctv_down_back(int x,int y,int len) {
		while(len!=0) {
			x++;
			if(arr[x][y]==-2) {
				arr[x][y]=0;
				len--;
			}
		}
		
		
	}
	static int cctv_left(int x,int y) {
		int left=0;
		while(true) {
			y -= 1;
			if( y< 0 || arr[x][y]==6) {
				y++;
				break;
			}
			if(arr[x][y]==0) {
				arr[x][y]=-3;
				left++;
			}
		}
		return left;
	}
	static void cctv_left_back(int x,int y,int len) {
		while(len!=0) {
			y--;
			if(arr[x][y]==-3) {
				arr[x][y]=0;
				len--;
			}
		}
	}
	static int cctv_right(int x,int y) {
		int right=0;
		while(true) {
			y += 1;
			if( y>= M || arr[x][y] == 6) {
				y--;
				break;
			}
			if(arr[x][y] ==0) {
				arr[x][y] = -4;
				right++;
			}
		}
		return right;
	}
	static void cctv_right_back(int x,int y,int len) {
		while(len!=0) {
			y++;
			if(arr[x][y]==-4) {
				arr[x][y]=0;
				len--;
			}
		}			
	}
	
}
