import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Backjoon_17135 {
	static int N,M,D;
	static int enemy_cnt;
	
	
	
	static int[][] map = new int[100][100]; //마지막 행에는 궁수가 위치
	//static int[][] simul_map = new int[17][17]; //시뮬용 복사용 맵
	
	static int arch_pos[] = new int[20]; // 궁수 존재 여부
	static Node arch_target[] = new Node[3]; //궁수의 공격 대상
	static boolean check[][] = new boolean[100][100]; //활 지나갔는지 여부
	static int result;
	
	
	static int[] ni = {0,1,0};
	static int[] nj = {-1,0,1};
	
	public static class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		D = Integer.parseInt(st.nextToken(" "));
		
		enemy_cnt = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[N-i][j] = Integer.parseInt(st.nextToken(" "));
				if(map[N-i][j]==1) enemy_cnt++;
			}
		}
		
		result = 0;
		
		for(int i=0;i<3;i++)
			arch_pos[i] = 1;
		
		do{
//			for(int i = 0; i<N;i++) {
//				System.out.print(arch_pos[i]);				
//			}
//			System.out.println();
						
			game_play();
			
		}while(comb(arch_pos));
		
		
//		arch_pos[1]=1;
//		arch_pos[4] =1;
//		arch_pos[7]=1;
//		game_play();
		
		System.out.println(result);
	}
	
	
	static void archer_attack(int pos,int archer_num,int[][] simul_map) {
		Queue<Node> q = new LinkedList();
		int x,y;
		boolean flag = true;
		
		for(int i=0;i<=N;i++) {
			Arrays.fill(check[i], false); 
		}
		
		q.add(new Node(0,pos));
		Node now;
		arch_target[archer_num] = new Node(-1,-1);
		while(!q.isEmpty() && flag) {
			now = q.poll();
			for(int d=0;d<3;d++) {
				x = ni[d] + now.i;
				y = nj[d] + now.j;
				
				
				
				
				if(Math.abs(0 - x)+Math.abs(pos-y) > D) break;				
				if(x < 1 || y < 1 || x >N || y > M || check[x][y]) {
					continue;
				}
				
				
				
				if(simul_map[x][y] == 1) {
					arch_target[archer_num] = new Node(x,y);
					flag = false;
					break;
				}
				
				check[x][y] = true;
				q.add(new Node(x,y));
				
			}
			
			
		}
		
		
	}
	
	
	static void game_play() {
		int wave_remain = N;
		int archer_num=0;
		int score = 0;
		
		int simul_map[][] = new int[100][100];
		
		for(int i=0;i<=N;i++) {	//맵 복사
			for(int j=1;j<=M;j++) {
				simul_map[i][j] = map[i][j];
			}
		}
		
		
		while(wave_remain > 0) {				
			archer_num = 0;			
//			System.out.println("---------------------");
//			for(int i=0;i<=N;i++) {
//				for(int j=1;j<=M;j++) {
//					System.out.print(simul_map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			for(int t=0;t<M;t++) { //모든 궁수 공격 대상 찾기
				if(arch_pos[t]==1) {					
					archer_attack(t+1, archer_num++,simul_map);		
				}			
			}
			
			for(int t=0;t<3;t++) { //타겟 대상 처리
				if(arch_target[t].i != -1 && simul_map[arch_target[t].i][arch_target[t].j] == 1) {
					score++;
					enemy_cnt--;
					simul_map[arch_target[t].i][arch_target[t].j] = 0;
					//System.out.println("타겟 : "+arch_target[t].i+ " "+arch_target[t].j);
				}							
			}
			
			for(int i=1;i<N;i++) {
				for(int j=1;j<=M;j++) {
					simul_map[i][j] = simul_map[i+1][j];
				}
			}
			for(int j=1;j<=M;j++) {
				simul_map[N][j] = 0;
			}
			
			wave_remain--;
			
			
		}
		
		
		result = Math.max(result, score);
		
	}
	
	
	
	static boolean comb(int pos[]) {		
		int i = 0;
		while(i < M-1 && pos[i] <= pos[i+1])
			i++;
		
		if(i==M-1) return false;
		
		int j = 0;
		
		while(pos[j] <= pos[i+1])
			j++;
		
		swap(pos,j,i+1);
		
		int k=0;
		
		while(k < i) {
			swap(pos,k++,i--);
		}
		
		return true;
	}
	
	static void swap(int arr[], int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] =  temp;	
		
	}
	
}
