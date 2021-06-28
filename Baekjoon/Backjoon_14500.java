import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14500 {
	static class Block{
		int ni[] = new int[4];
		int nj[] = new int[4];
		Block(){}
		Block(int i1, int j1, int i2,int j2, int i3, int j3, int i4, int j4){
			this.ni[0] = i1;
			this.ni[1] = i2;
			this.ni[2] = i3;
			this.ni[3] = i4;
			
			this.nj[0] = j1;
			this.nj[1] = j2;
			this.nj[2] = j3;
			this.nj[3] = j4;
		}
	}
	
	static int N,M;
	static int arr[][];
	
	
	static Block block[] = new Block[19];
	
	
	
	public static void main(String[] args) throws IOException {
		int result=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		// ㅡ 모양
		block[0] = new Block(0,0,0,1,0,2,0,3);
		block[1] = new Block(0,0,1,0,2,0,3,0);
		// ㅁ 모양 
		block[2] = new Block(0,0,0,1,1,0,1,1);
		// ㄴ 모양 
		block[3] = new Block(0,0,1,0,2,0,2,1);
		block[4] = new Block(0,0,0,1,0,2,1,0);
		block[5] = new Block(0,0,0,1,1,1,2,1);
		block[6] = new Block(0,2,1,0,1,1,1,2);
		
		block[7] = new Block(0,1,1,1,2,1,2,0);
		block[8] = new Block(0,0,0,1,0,2,1,2);
		block[9] = new Block(0,0,0,1,1,0,2,0);
		block[10] = new Block(0,0,1,0,1,1,1,2);
		
		
		
		// 번개모양
		block[11] = new Block(0,0,1,0,1,1,2,1);
		block[12] = new Block(1,0,1,1,0,1,0,2);
		block[13] = new Block(0,1,1,1,1,0,2,0);
		block[14] = new Block(0,0,0,1,1,1,1,2);
		//ㅗ 모양
		block[15] = new Block(0,0,0,1,0,2,1,1);
		block[16] = new Block(0,0,1,0,1,1,2,0);
		block[17] = new Block(0,1,1,0,1,1,1,2);
		block[18] = new Block(0,1,1,0,1,1,2,1);

		
//		for(int b=0;b<19;b++) {
//			block_draw(0,0,b);
//		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				result= Math.max(result, block_check(i,j));
			}
		}
		System.out.println(result);
		
		
	}
	
	static void block_draw(int idx_i,int idx_j,int b) {
		int paper[][] = new int[4][4];
		

		int x,y;
		int result = 0;
		int sum;
		int cnt;		
		
			cnt = 0;
			sum=0;
			for(int d=0;d<4;d++) {
				x = idx_i + block[b].ni[d];
				y = idx_j + block[b].nj[d];
				
				if(x<0 || y<0|| x>=N || y>=M) break;
				
				cnt++;
				paper[x][y] = 1;			
			}			
	
		
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(paper[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------");
		
		
	}
	
	static int block_check(int idx_i, int idx_j) {
		
		int x,y;
		int result = 0;
		int sum;
		int cnt;
		
		for(int b=0;b<19;b++) {
			cnt = 0;
			sum=0;
			for(int d=0;d<4;d++) {
				x = idx_i + block[b].ni[d];
				y = idx_j + block[b].nj[d];
				
				if(x<0 || y<0|| x>=N || y>=M) break;
				
				cnt++;
				sum += arr[x][y];				
			}
			if(cnt==4) result = Math.max(result, sum);
			
			
		}
		
		
		
		return result;
	}
	
}
