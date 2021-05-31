import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

//백준17141 연구소2 : https://www.acmicpc.net/problem/17141


public class Backjoon_17141 {
	
	public static class Node{
		int x,y;
		
		Node(){}
		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] ni = {-1,1,0,0};
	static int[] nj = {0,0,-1,1};
	static int n; // 연구소 크기 n*n , 5이상 50 이하
	static int m; // 바이러스의 갯 수
	static int[][] arr = new int[50][50]; // 0은 빈 칸 1은 벽 2는 바이러스가 위치할 수 있는 공간
	static int[][] map = new int[50][50]; // 시뮬레이션용 배열
	static Vector<Node> v = new Vector(); // 바이러스 초기 위치 저장 벡터
	static Vector<Node> virus = new Vector(); //바이러스 진행 위치 저장 벡터
	static Vector<Node> spread_virus = new Vector(); // 퍼지는 바이러스 벡터
	static int time; // 퍼지는 시간 얼마나 걸렸는지 저장하는 변수
	static int count=0;
	static int space_count=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		
	
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken(" "));
		m = Integer.parseInt(st.nextToken(" "));
		
		time = 2500;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				if(arr[i][j] ==0 ) arr[i][j] = 2500;
				else if(arr[i][j] == 1) arr[i][j] = -1; //벽이면 -1로 치환
				else if(arr[i][j] == 2) {
					arr[i][j] = 2500;
					v.add(new Node(i,j));
					space_count++;
				}
		
			}
			
		}
		virus_choice(0,0);
		if(time==2500)System.out.println(-1);
		else System.out.println(time);
		
	}
	
	static void virus_Spread() {		
		Node node = new Node();
		int nx, ny;
		int spread_time=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = arr[i][j];
			}
		} //맵 초기화
		
		for(int i=0;i<virus.size();i++) {
			node = virus.get(i);
			spread_virus.add(node);
			map[node.x][node.y] = 0;
		}	//퍼지는 바이러스 위치 초기화
		
		
		
		while(!spread_virus.isEmpty()) {
			node = spread_virus.remove(0);
			for(int d=0;d<4;d++) {
				nx = node.x + ni[d];
				ny = node.y + nj[d];
				
				if(nx <0 || ny < 0 || nx >=n || ny >=n || map[nx][ny] == -1) {
					continue;					
				}	
				
				if(map[nx][ny] > map[node.x][node.y]+1) {
					map[nx][ny] = map[node.x][node.y]+1;
					spread_virus.add(new Node(nx,ny));
				}
				
			}			
		} //바이러스 퍼트림
		//System.out.println("*********case**********");
		count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				//System.out.printf("%5d",map[i][j]);
				if(spread_time < map[i][j]) {
					spread_time = map[i][j];
				}				
			}
			//System.out.println();
		} // 최대로 걸린 시간 찾기
	
		
		if(time > spread_time) time = spread_time; //최소 시간 바꿔주기
		//System.out.println("spread_time = "+spread_time);
		spread_virus.clear();
		
	}
	
	static void virus_choice(int index, int v_count) {
		if(v_count == m) {
			
			virus_Spread();
			
			
		} else {
			for(int i=index; i < v.size();i++) {
				virus.add(v.get(i));
				virus_choice(i+1,++v_count);				
				virus.remove(--v_count);
			}			
			
		}		
	}
	

	
}
