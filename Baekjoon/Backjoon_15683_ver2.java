
// 백준 15683 감시
// 주소 : https://www.acmicpc.net/problem/15683

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_15683_ver2 {
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
	static int ni[] = {-1,0,1,0};
	static int nj[] = {0,1,0,-1};
	static int type[][] = {{0,0,0,0},{0,1,0,0},{0,1,0,1},{1,1,0,0},{1,1,0,1},{1,1,1,1}};
	
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
		int x,y,len_sum;
		int len[] = new int[4];
		int way[] = new int[4];
		if(idx==cctv_pos.size()) {
			result = Math.min(result, cnt);
			return;
		}
		node = cctv_pos.get(idx);
		
		x = node.i;
		y = node.j;
		
		for(int i=0;i<4;i++) {
			way[i] = type[node.type][i];
		} //카메라 방향 복사
		
		for(int r=0;r<4;r++) {//회전 
			len_sum=0;
			for(int d=0;d<4;d++) { //방향 - 상우하좌
				if(way[d]==1) { //방향을 볼 수 있을 때 체크
					len[d]=cctv_look(x,y,d);
					len_sum += len[d];
				}
			}
			
			DFS(idx+1, cnt-len_sum);
			
			for(int d=0;d<4;d++) { //본 방향 다시 초기화
				if(way[d]==1)
					cctv_look_back(x,y,len[d],d);
			}			
			int temp;
			temp = way[0];
			way[0] = way[3];
			way[3] = way[2];
			way[2] = way[1];
			way[1] = temp; //90도 회전
			
		}
	}
	

	static int cctv_look(int x, int y, int dir) {
		int len=0;
		
		while(true) {
			x +=ni[dir];
			y +=nj[dir];
			
			if(x<0 || y<0 || x>=N || y>= M || arr[x][y]==6) {
				x -= ni[dir];
				y -= nj[dir];
				break;
			}
			
			if(arr[x][y]==0) {
				arr[x][y] = -(dir+1);
				len++;
			}				
		}
		
		return len;
	}
	static void cctv_look_back(int x, int y, int len,int dir) {
		while(len!=0) {
			x += ni[dir];
			y += nj[dir];
			if(arr[x][y]==-(dir+1)) {
				arr[x][y]=0;
				len--;
			}
		}
	}
	
	
	
}
