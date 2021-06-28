// 백준 13460 구슬 탈출 2
// 주소 : https://www.acmicpc.net/problem/13460


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_13460 {
	static public class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
	
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	static boolean visit[][][][] = new boolean[10][10][10][10];
	static boolean visit_red[][] = new boolean[10][10];
	static boolean visit_blue[][] = new boolean[10][10];
	static boolean red_out;
	static boolean blue_out;
	
	
	static char map[][] = new char[10][10];
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		Node red = new Node();
		Node blue = new Node();
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'R') {
					map[i][j] ='.';
					red = new Node(i,j);
					visit_red[i][j] = true;
				}else if(map[i][j] == 'B') {
					blue = new Node(i,j);
					visit_blue[i][j] = true;
					map[i][j] ='.';
				}
			}
		}
		maze(red,blue);
		
		
	}
	
	static void maze(Node r, Node b) {
		
		Queue<Node> q = new LinkedList();		
		
		int red_x,red_y;
		int blue_x,blue_y;
		visit[r.i][r.j][b.i][b.j]= true; 
		q.add(r);
		q.add(b);
		
		Node red;
		Node blue;
		
		
		int time=0;
		
		while(!q.isEmpty() && time <10 && !red_out) {
			int q_size = q.size();
			time++;
			//System.out.println("시간 : "+time);
			for(int _q=0;_q<q_size/2;_q++) {
				red = q.poll();
				blue = q.poll();
				
				if(red_out) break;
				
				for(int d=0;d<4;d++) {
					red_x = red.i;
					red_y = red.j;
					blue_x = blue.i;
					blue_y = blue.j;
					


					while(true) {
						if(red_x + ni[d] >= 0 && red_x+ni[d] <N && red_y + nj[d] >=0 && red_y + nj[d] < M && map[red_x+ni[d]][red_y+nj[d]]!='#') {
							red_x = red_x + ni[d];
							red_y = red_y + nj[d];
							//System.out.println(" ! "+red_x+" "+red_y);
							if(map[red_x][red_y]=='O') {
								red_x = -1;
								red_y = -1;
								break;
							}
							
						}else {
							break;
						}					
					}
					
					while(true) {
						if(blue_x + ni[d] >= 0 && blue_x+ni[d] <N && blue_y + nj[d] >=0 && blue_y + nj[d] < M && map[blue_x+ni[d]][blue_y+nj[d]]!='#') {
							blue_x = blue_x + ni[d];
							blue_y = blue_y + nj[d];
							if(map[blue_x][blue_y]=='O') {
								blue_x = -1;
								blue_y = -1;
								blue_out =true;
								break;
							}
							
						}else {
							break;
						}					
					}	
					
			
					
					if(blue_x == -1) {
						//System.out.println("파랑");
						continue;
					}
					if(red_x == -1) {
						//System.out.println("빨강"+blue_x);
						red_out = true;
						break;
					}
					
				
					
					if(red_x == blue_x && red_y == blue_y) {
						if(d==0) {
							if(red.i < blue.i) blue_x++;
							else red_x++;
						}else if(d==1) {
							if(red.i < blue.i)red_x--;
							else blue_x--;							
						}else if(d==2) {
							if(red.j < blue.j) blue_y++; 
							else red_y++;
						}else if(d==3) {
							if(red.j < blue.j)red_y--;
							else blue_y--;
							
						}						
					}
					
				//	System.out.println("빨강"+red_x+" "+red_y);
					//System.out.println("파랑"+blue_x+" "+blue_y);
					
					
//					if(!visit_red[red_x][red_y] || !visit_blue[blue_x][blue_y]) {
//						visit_red[red_x][red_y] = true; 
//						visit_blue[blue_x][blue_y] = true;
//						q.add(new Node(red_x,red_y));
//						q.add(new Node(blue_x,blue_y));
//						
//					}
					if(!visit[red_x][red_y][blue_x][blue_y]) {
						visit_red[red_x][red_y] = true; 
						visit_blue[blue_x][blue_y] = true;
						q.add(new Node(red_x,red_y));
						q.add(new Node(blue_x,blue_y));
					}
					
					
				}
				
				
			}
			
			
		}
		if(red_out)
			System.out.println(time);
		else {
			System.out.println(-1);
		}
		
	}
	
}
