import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_17143 {
	static class Shark implements Comparable<Shark>{
		int i,j,speed,dir,size,idx;
		Shark(){}
		Shark(int i,int j, int speed, int dir,int size,int idx){
			this.i = i;
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.idx = idx;
		}
		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return o.size - this.size;
		}
	}
	
	
	static int R,C,M;
	static List<Shark> shark;
	static int arr[][];
	static int arr_z[][];
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		shark = new ArrayList();
		arr = new int[R][C];
		arr_z = new int[R][C];
		int x,y,s,d,size;
		//방향 1상 2하 3우 4좌
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken(" ")) - 1;
			y = Integer.parseInt(st.nextToken(" ")) - 1;
			s = Integer.parseInt(st.nextToken(" "));
			d = Integer.parseInt(st.nextToken(" "));
			size = Integer.parseInt(st.nextToken(" "));
			shark.add(new Shark(x,y,s,d,size,i));
			arr[x][y] = i;
			arr_z[x][y] = size;
		}
		
		Collections.sort(shark);
		
			

		
		int result;
		result = simulate();
		System.out.println(result);
			
		
	}
	
	static int simulate() {
		int result=0;
		int shark_size;
		int x,y,speed,dir,size;
		for(int t=0;t<C;t++) { 
			
			//상어 이동 위치 확인용
//			for(int i=0;i<R;i++) {
//				for(int j=0;j<C;j++) {
//					System.out.print(arr_z[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("-------------------");
			
			
			
			
			for(int i=0;i<R;i++) { //낚시왕이 오른쪽으로 이동 후 상어를 잡는다
				if(arr[i][t]!=0) {
					shark_size = shark.size();
					for(int p=0;p<shark_size;p++) {
						if(arr[i][t] == shark.get(p).idx) {
							result += shark.get(p).size;
							shark.remove(p);
							break;
						}
					}
					arr[i][t] = 0;
					arr_z[i][t] = 0;
					break;
					}
					
					
			}
			//상어 사냥 끝
			
			
			
			//상어 이동 시작
			shark_size = shark.size();
			for(int p=0;p<shark_size;p++) {
				x = shark.get(p).i;
				y = shark.get(p).j;
				if(arr[x][y]==shark.get(p).idx) {
					arr[x][y]=0;
					arr_z[x][y]=0;
				}
				
				speed = shark.get(p).speed;
				dir = shark.get(p).dir;
				size = shark.get(p).size;
				
				if(dir==1 | dir==2) {
					speed = speed % (2*R - 2);				
				}else if(dir == 3 || dir == 4 ) {
					speed = speed % (2*C - 2);
				}
				
				for(int s=0;s<speed;s++) {					
					if(dir==1) {//상
						x += ni[0];
						y += nj[0];
						if(x < 0 || y< 0 || x>=R || y>=C) {
							dir=2;
							x+= ni[1]*2;
							y+= nj[1]*2;
						}
						
						
					}else if(dir==2) {//하
						x += ni[1];
						y += nj[1];
						if(x < 0 || y< 0 || x>=R || y>=C) {
							dir=1;
							x+= ni[0]*2;
							y+= nj[0]*2;
						}
						
					}else if(dir==3) {//우
						x += ni[2];
						y += nj[2];
						if(x < 0 || y< 0 || x>=R || y>=C) {
							dir=4;
							x+= ni[3]*2;
							y+= nj[3]*2;
						}
					}else if(dir==4) {//좌
						x += ni[3];
						y += nj[3];
						if(x < 0 || y< 0 || x>=R || y>=C) {
							dir=3;
							x+= ni[2]*2;
							y+= nj[2]*2;
						}
					}					
				}
				
			
				
				if(arr[x][y]!=0 && arr_z[x][y] > size) {
					shark.remove(p);
					shark_size--;
					p--;
				}else {
					arr[x][y] = shark.get(p).idx;
					arr_z[x][y] = size;
					shark.get(p).i = x;
					shark.get(p).j = y;
					shark.get(p).dir = dir;
				}
				
				
			} // 상어 이동 끝		
			
			
		}
		
		return result;
	}
}

