// 백준 15686 치킨 배달
// 주소 : https://www.acmicpc.net/problem/15686


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_15686 {
	static public class Node{
		int i,j;
		Node(){
			
		}
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
		
	}
	
	
	static int[][] map = new int[51][51]; //지도 1~50 만 사용
	static Node[] chicken_pos = new Node[13]; // 치킨집 위치, 치킨 집은 13개 이하
	static Node[] home_pos = new Node[100]; //집 위치 , 집은 2N개를 넘지 않음
	static int[] open_chicken = new int[13];
	static int result;
	static int home_cnt, chicken_cnt; //집 , 치킨 집 수
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M, bit;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		home_cnt = 0;
		chicken_cnt=0;
		result =Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken(" "));
				if(map[i][j] == 1) home_pos[home_cnt++] = new Node(i,j);
				else if(map[i][j] == 2) chicken_pos[chicken_cnt++] = new Node(i,j);
			}
			
		}
		
		for(int i=0;i<M;i++) {
			open_chicken[i] = 1;
		}
		
		do {
			calc();
		
			
		}while(comb());
		
		System.out.println(result);
		
	}
	
	
	
	static void calc() {
		int sum= 0;
		int distance = 0;
		
		for(int i=0;i<home_cnt;i++) {
			distance = Integer.MAX_VALUE;
			for(int j=0;j<chicken_cnt;j++) {
				if(open_chicken[j]==1) {
					distance = Math.min(distance, Math.abs(home_pos[i].i - chicken_pos[j].i) + Math.abs(home_pos[i].j - chicken_pos[j].j));

				}
				
			}
			sum += distance;
			
		}
		result = Math.min(result, sum);
		
	}
	
	
	
	static boolean comb() {
		
		int i = 0;
		
		while(i < chicken_cnt - 1 && open_chicken[i] <= open_chicken[i+1] )
			i++;
		
		if(i==chicken_cnt-1)
			return false;
		
		int j=0;
		
		while(open_chicken[j] <= open_chicken[i+1])
			j++;
		
		swap(i+1,j);
		
		
		int k=0;		
		
		while(k < i) {
			swap(k++,i--);
		}
		
		
		return true;
		
	}
	static void swap(int i, int j) {
		int temp = open_chicken[i];
		open_chicken[i] = open_chicken[j];
		open_chicken[j] = temp;
	}
	
	
}
