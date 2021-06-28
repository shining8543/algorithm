import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1520 {
	static int N,M;
	static int arr[][];
	static int ans[][];
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		int result;
		arr = new int[N][M];
		ans = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));				
			}
		}
		DFS(N-1,M-1);
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.printf("%3d",ans[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(ans[N-1][M-1]);
		
	}
	static int DFS(int i,int j) {
		int x,y;
		if(i==0 && j==0) {
			return ans[i][j]=1;
		}
		
		if(visit[i][j]) return ans[i][j];
		visit[i][j] = true;
		
		
		for(int d=0;d<4;d++) {
			x = i+ni[d];
			y = j+nj[d];
			if(x<0 || y<0 || x>=N || y>=M) continue;
			
			if(arr[i][j] < arr[x][y]) {
				ans[i][j] += DFS(x,y);
			}
			
		}
		
		
		return ans[i][j];
	}
	
}
