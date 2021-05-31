// 백준 16935 배열 돌리기3
// 주소 : https://www.acmicpc.net/problem/16935


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_16935 {
	
	static int n,m,r; //세로 가로 명령수
	static int[][] arr = new int[100][100];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] rotate = new int[100][100];
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken(" "));
		m = Integer.parseInt(st.nextToken(" "));
		r = Integer.parseInt(st.nextToken(" "));
		int token;
		int tmp;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int k=0;k<r;k++) {
			token = Integer.parseInt(st.nextToken(" "));		
			switch(token) {
			case 1:
				for(int i=0;i<n/2;i++) {
					for(int j=0;j<m;j++) {
						tmp = arr[i][j];
						arr[i][j] = arr[n-i-1][j];
						arr[n-i-1][j] = tmp;
					}
				}				
				break;
				
			case 2:
				for(int i=0;i<n;i++) {
					for(int j=0;j<m/2;j++) {
						tmp = arr[i][j];
						arr[i][j] = arr[i][m-j-1];
						arr[i][m-j-1] = tmp;
					}
				}
				
				break;
				
			case 3:
				for(int i=0;i<m;i++) {
					for(int j=0; j<n;j++) {
						rotate[i][j] = arr[n-1-j][i];
					}
				}
				
				tmp = n;
				n = m;
				m = tmp;
				
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						arr[i][j] = rotate[i][j];
					}
				}
				
				break;
				
			case 4:
				for(int i=0;i<m;i++) {
					for(int j=0; j<n;j++) {
						rotate[i][j] = arr[j][m-1-i];
					}
				}
				
				tmp = n;
				n = m;
				m = tmp;
				
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						arr[i][j] = rotate[i][j];
					}
				}
				break;
				
			case 5:
				for(int i=0;i<n/2;i++) {
					for(int j=0;j<m/2;j++) {
						tmp = arr[i][j];
						arr[i][j] = arr[i+n/2][j];
						arr[i+n/2][j] = arr[i+n/2][j+m/2];
						arr[i+n/2][j+m/2] = arr[i][j+m/2];								
						arr[i][j+m/2] = tmp;						
					}
				}	
				
				break;
				
			case 6:
				for(int i=0;i<n/2;i++) {
					for(int j=0;j<m/2;j++) {
						tmp = arr[i][j];
						arr[i][j] = arr[i][j+m/2];
						arr[i][j+m/2] = arr[i+n/2][j+m/2];
						arr[i+n/2][j+m/2] = arr[i+n/2][j];
						arr[i+n/2][j]= tmp;						
					}
				}					
				break;				
			
			
			
			}
			
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0; j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
