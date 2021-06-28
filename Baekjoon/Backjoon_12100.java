
// 백준 12100 2048(easy)
// 주소 : https://www.acmicpc.net/problem/12100


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_12100 {
	
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	
	static int N;
	static int arr[][] = new int[20][20];
	static int play_arr[][] = new int[20][20];
	static int max_num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				max_num = Math.max(max_num,arr[i][j]);
			}
		}
		
		
		play(0,arr);
		System.out.println(max_num);
		
		
	}
	static void print_arr() {
		System.out.println("--------------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.printf("%5d",play_arr[i][j]);
			}
			System.out.println();
		}
	}
	
	static void arr_copy(int arr1[][], int arr2[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr2[i][j] = arr1[i][j];
			}
		}
	}
	
	static void play(int cnt, int _arr[][]) {
		
		int temp[][] = new int[N][N];
		arr_copy(_arr,temp);	
		if(cnt == 5 ) {
			return;
		}else {			
			arr_copy(temp,play_arr);
			up(cnt+1);			
			arr_copy(temp,play_arr);
			down(cnt+1);
			arr_copy(temp,play_arr);
			left(cnt+1);
			arr_copy(temp,play_arr);
			right(cnt+1);
		}
		
	}
	
	static void up(int cnt) {
		
		boolean isMerge[][] = new boolean[N][N];
		int x,y,num;
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<N;j++) {
				x = i;
				y = j;
				while(true) {
					x=x-1;
					if(x < 0) {
						play_arr[x+1][y]=play_arr[i][j];
						play_arr[i][j] = 0;						
						break;
					}
					
					if(play_arr[x][y]!=0) {					
						if(!isMerge[x][y] && play_arr[x][y]==play_arr[i][j]) {
							num = play_arr[x][y] * 2;
							max_num = Math.max(max_num, num);
							play_arr[i][j] = 0;
							
							while(true) {
								x=x-1;
								if(x < 0) {
									play_arr[0][y]=num;
									isMerge[0][y] = true;
									break;
								}
								if(play_arr[x][y]!=0) {
									play_arr[x+1][y] = num;
									isMerge[x+1][y] = true;
									break;
								}
							}
							
							
							break;
						}else {
							play_arr[x+1][y] = play_arr[i][j];
							if(x+1 != i)
								play_arr[i][j]=0;
							break;
						}					
					}
					
					
				}				
			}
		}
		play(cnt,play_arr);
		
	}
	static void down(int cnt) {
		
		boolean isMerge[][] = new boolean[N][N];
		int x,y,num;
		
		for(int i=N-2;i>=0;i--) {
			for(int j=0;j<N;j++) {
				x = i;
				y = j;
				while(true) {
					x=x+1;
					if(x >= N) {
						play_arr[N-1][y]=play_arr[i][j];
						play_arr[i][j] = 0;						
						break;
					}
					
					if(play_arr[x][y]!=0) {					
						if(!isMerge[x][y] && play_arr[x][y]==play_arr[i][j]) {
							num = play_arr[x][y] * 2;
							max_num = Math.max(max_num, num);
							play_arr[i][j] = 0;
							
							while(true) {
								x=x+1;
								if(x >= N) {
									play_arr[N-1][y]=num;
									isMerge[N-1][y] = true;
									break;
								}
								if(play_arr[x][y]!=0) {
									play_arr[x-1][y] = num;
									isMerge[x-1][y] = true;
									break;
								}
							}
							
							
							break;
						}else {
							play_arr[x-1][y] = play_arr[i][j];
							if(x-1 != i)
								play_arr[i][j]=0;
							break;
						}					
					}
					
					
				}				
			}
		}
		
		play(cnt,play_arr);
		
	}
	static void left(int cnt) {
		boolean isMerge[][] = new boolean[N][N];
		int x,y,num;
		
		for(int j=1;j<N;j++) {
			for(int i=0;i<N;i++) {
				x = i;
				y = j;
				while(true) {
					y=y-1;
					if(y < 0) {
						play_arr[x][y+1]=play_arr[i][j];
						play_arr[i][j] = 0;						
						break;					
					} 
					
					if(play_arr[x][y]!=0) {					
						if(!isMerge[x][y] && play_arr[x][y]==play_arr[i][j]) {
							num = play_arr[x][y] * 2;
							max_num = Math.max(max_num, num);
							play_arr[i][j] = 0;
							
							while(true) {
								y=y-1;
								if(y < 0) {
									play_arr[x][y+1]=num;
									isMerge[x][y+1] = true;
									break;
								}
								if(play_arr[x][y]!=0) {
									play_arr[x][y+1] = num;
									isMerge[x][y+1] = true;
									break;
								}
							}
							
							
							break;
						}else {
							play_arr[x][y+1] = play_arr[i][j];
							if(y+1 != j)
								play_arr[i][j]=0;
							break;
						}					
					}
					
				}
				
			}
		}
		play(cnt,play_arr);
	}
	static void right(int cnt) {
		boolean isMerge[][] = new boolean[N][N];
		int x,y,num;
		
		for(int j=N-2;j>=0;j--) {
			for(int i=0;i<N;i++) {
				x = i;
				y = j;
				while(true) {
					y=y+1;
					if(y >= N) {
						play_arr[x][y-1]=play_arr[i][j];
						play_arr[i][j] = 0;						
						break;					
					} 
					
					if(play_arr[x][y]!=0) {					
						if(!isMerge[x][y] && play_arr[x][y]==play_arr[i][j]) {
							num = play_arr[x][y] * 2;
							max_num = Math.max(max_num, num);
							play_arr[i][j] = 0;
							
							while(true) {
								y=y+1;
								if(y >= N) {
									play_arr[x][y-1]=num;
									isMerge[x][y-1] = true;
									break;
								}
								if(play_arr[x][y]!=0) {
									play_arr[x][y-1] = num;
									isMerge[x][y-1] = true;
									break;
								}
							}
							
							
							break;
						}else {
							play_arr[x][y-1] = play_arr[i][j];
							if(y-1 != j)
								play_arr[i][j]=0;
							break;
						}					
					}
					
				}
				
			}
		}
		play(cnt,play_arr);
	}
}
