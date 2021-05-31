// 백준 14719 빗물
// 주소 : https://www.acmicpc.net/problem/14719


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_14719 {
	static class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
	
	
	
	static int H,W;
	static int arr[][] = new int[500][500];
	
	static Queue<Node> q = new LinkedList();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int height;
		
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken(" "));
		W = Integer.parseInt(st.nextToken(" "));
		
		
		
		st = new StringTokenizer(br.readLine());
		for(int w=0;w<W;w++) {
			height = Integer.parseInt(st.nextToken(" "));
			for(int h=0;h<height; h++) {
				arr[h][w] = 1;
				q.add(new Node(h,w));
			}
		}
		BFS();
		
	}
	static void BFS() {
		int x,y;
		Node node;
		int len;
		int result=0;
	
		
		
		while(!q.isEmpty()) {
			
			node = q.poll();
			len =0;
			x = node.i;
			y = node.j;
			while(true) {				
				y += 1;
				if(y >= W) {
					len = 0;
					break;
				}
				if(arr[x][y]==1) {					
					result+=len;
					break;					
				}
				len++;
				
			}
			
		}
		System.out.println(result);
		
	}
	
}
