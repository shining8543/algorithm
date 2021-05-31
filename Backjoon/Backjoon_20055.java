import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_20055 {
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<Integer> robot = new LinkedList();

		boolean isThere[];
		
		int N,K;
		int belt[];
		
		
		int num;
		int cnt;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		belt = new int[2*N];
		isThere = new boolean[2*N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) {
			belt[i] = Integer.parseInt(st.nextToken(" "));
		}	

		
		
		// 입력 끝
		
		cnt = 0;
		int up = 0;
		int down = N-1;
		int q_size;
		int next;
		int turn=0;
		while(cnt < K) {
			turn ++;
			up = (2*N+(up-1)) % (2*N);
			down = (2*N+(down-1)) % (2*N);
			//한칸 회전
		
			q_size = robot.size();
			for(int q=0;q<q_size;q++){
				num = robot.poll();
				next = (num+1)%(2*N);
				if(num == down) { //바로 내려가는 경우
					isThere[num] = false;
				}else if(belt[next]>0 && next == down) { //한칸 이동하자마자 내려가는 경우
					isThere[num] =false;
					belt[next]--;
					if(belt[next]<=0) cnt++;
				}else if(!isThere[next] && belt[next]>0) { // 한칸 이동하는 경우
					
					isThere[num] = false;
					isThere[next] = true;
					belt[next]--;
					if(belt[next]<=0) cnt++;
					robot.add(next);
				}else {
					isThere[num] = true;
					robot.add(num);
				}
			}
			// 로봇 이동

			if(!isThere[up] && belt[up] > 0) {
				isThere[up] = true;
				belt[up]--;
				if(belt[up] <= 0) cnt++;
				robot.add(up);
			}	
			
		}
		
		System.out.println(turn);
		
		
		
		
	}
}
