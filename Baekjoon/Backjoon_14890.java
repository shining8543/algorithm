import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14890 {
	
	static int N, ramp_len; //N 6이상 20이하 , len 2이상 4이하
	static int arr[][]; //지형의 높이는 1이상 6이하
	static int result;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t_case;
		
		//st = new StringTokenizer(br.readLine());
		//t_case = Integer.parseInt(st.nextToken(" "));
		t_case = 1;
		
		for(int t=1;t<=t_case;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken(" "));
			ramp_len = Integer.parseInt(st.nextToken(" "));
			
			arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken(" "));
				}
			}
			
			runaway();
			
			System.out.println(result);
			
			
		}	
		
	}
	static void runaway() {
		int count = 0;
		
		for(int i=0;i<N;i++) {
			if(isPossible(0,i)) {
				//System.out.println(i+"번째 가로줄 가능");
				count++;
			}
		}
		
		for(int j=0;j<N;j++) {
			if(isPossible(1,j)) {
				//System.out.println(j+"번째 세로줄 가능");
				count++;
			}
		}
		
		result = count;
		
		
		
	}
	
	static boolean isPossible(int dir, int idx) {
		int now_len;
		int now_height;
		boolean need_chk = false;
		// 가로줄 확인
		if(dir==0) {
			now_height = arr[idx][0];
			now_len=0;
			
			for(int j=0;j<N;j++) {								
				if(need_chk && now_len >= ramp_len) {
					now_len=0;
					need_chk = false;			
				}
				
				if(Math.abs(now_height- arr[idx][j]) >=2) return false;
				
				else if(now_height == arr[idx][j])
					now_len++;
				else if(now_height < arr[idx][j]) {
					//높은걸 만났을 때
					if(need_chk) return false;
					
					if(now_len >= ramp_len) { //경사로를 설치할 길이가 된다면
						now_len = 1;
						now_height = arr[idx][j];
					} else  //안된다면
						return false;					
				}else if(now_height > arr[idx][j]) {
					//낮은걸 만났을 때
					if(need_chk) return false;
					
					need_chk = true;
					now_len = 1;
					now_height = arr[idx][j];
				}
				
			}			
			
		}else { //세로줄 확인
			now_height = arr[0][idx];
			now_len=0;
			
			for(int i=0;i<N;i++) {
				if(need_chk && now_len >= ramp_len) {
					now_len=0;
					need_chk = false;			
				}
				
				
				if(Math.abs(now_height- arr[i][idx]) >=2) return false;
				
				else if(now_height == arr[i][idx])
					now_len++;
				else if(now_height < arr[i][idx]) {
					//높은걸 만났을 때
					if(need_chk) return false;
					
					if(now_len >= ramp_len) { //경사로를 설치할 길이가 된다면
						now_len = 1;
						now_height = arr[i][idx];
					} else  //안된다면
						return false;					
				}else if(now_height > arr[i][idx]) {
					
					if(need_chk) return false;
					
					need_chk = true;
					now_len = 1;
					now_height = arr[i][idx];
				}
				
			}		
			
			
		}
		
		if(need_chk && now_len < ramp_len) return false;
		
		
		return true;
	}
	
}
