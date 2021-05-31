import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17779 {
	static int N;
	//static int arr[][];
	static int map[][];
	static int map_sum;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		
		//arr = new int[N][N];
		map = new int[N][N];
		map_sum = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken(" "));
				map_sum += map[i][j];
			}
		}
		//입력 끝
		result = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				gerrymandering(i,j);				
			}
		}
		
		//cal(4,2,2,1);

		System.out.println(result);
	
		
		
	}
	static void gerrymandering(int i, int j) {
		
		for(int d2=1;d2<N-j;d2++) {
			for(int d1=1;d1<N-j;d1++) {
				if(j+d1+d2>=N || i - d1< 0 || i+d2 >= N) continue;
				
				
				cal(i,j,d1,d2);

				
				
				
				
					
					
			}
		}
	}
	static void cal(int start_i,int start_j,int d1, int d2) {
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int temp = 0;
		int sum = map_sum;
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++)
//				arr[i][j]=0;
//		}
//		
//		for(int i=0;i<=d1;i++) {
//			arr[start_i-i][i+start_j]=5;
//		}
//		for(int i=1;i<=d2;i++) {
//			arr[i+start_i][i+start_j]=5;
//		}
			
	
		
		for(int i=0;i<start_i; i++) {
			for(int j=0; j<=start_j+d1; j++) {
				if(j >= start_j+d1 - (i-(start_i-d1))) continue;
				temp += map[i][j];
				//arr[i][j]=1;
			}
		}
		//System.out.println(temp);
		max = Math.max(max, temp);
		min = Math.min(min, temp);
		sum -= temp;
		//1번 구역
		
		temp = 0;
		for(int i=0;i<=start_i-(d1-d2);i++) {
			for(int j=start_j+d1+1; j<N;j++) {
				if(i-(start_i-d1) > j - (start_j+d1+1)) continue;
				
				temp+= map[i][j];
				//arr[i][j]=2;
			}
		}
		//System.out.println(temp);
		max = Math.max(max, temp);
		min = Math.min(min, temp);
		sum -= temp;
		//2번 구역
		
		temp=0;
		for(int i=start_i;i<N;i++) {
			for(int j=0;j<start_j+d2;j++) {
				if(j - start_j>= i-start_i) continue;
				temp += map[i][j];
				//arr[i][j]=3;
				
			}
		}
		//System.out.println(temp);
		max = Math.max(max, temp);
		min = Math.min(min, temp);
		sum -= temp;
		//3번 구역
		
		
		temp =0;
		for(int i=start_i-d1+d2+1; i<N;i++) {
			for(int j=start_j+d2;j<N;j++) {
				if(i+j <= (start_i-d1+d2)+(start_j+d1+d2) ) continue;
				temp += map[i][j];
				//arr[i][j]=4;
			}
		}
		//System.out.println(temp);
		max = Math.max(max, temp);
		min = Math.min(min, temp);
		sum -= temp;
		//4번 구역
		
		///System.out.println(sum);
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		
		
		result = Math.min(result, max-min);
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		
		
		
		
		
	}
	
}	
