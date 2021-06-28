import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1697 {
	
	static int N,K;
	static boolean visit[] = new boolean[100005];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		
		Queue<Integer> q = new LinkedList();
		q.add(N);		
		visit[N] = true;
		boolean isFinish = false;
		int q_size;
		int time= -1;
		
		
		
		while(!q.isEmpty() && !isFinish) {
			q_size = q.size();
			time++;
			//System.out.println();
			for(int _q=0;_q<q_size;_q++) {
				idx = q.poll();
				//System.out.print(idx+" ");
				if(idx == K) {
					isFinish = true;
					break;
				}
				
				
				if(idx-1 >= 0 && !visit[idx-1]) {
					visit[idx-1] = true;
					q.add(idx-1);
				}
				
				if(idx + 1 <= K && !visit[idx+1]) {
					visit[idx+1] = true;
					q.add(idx+1);
				}
				
				if(idx*2 <= 100000 && idx*2 <= K*2 && !visit[idx*2]) {
					visit[idx*2] = true;
					q.add(idx*2);
				}
				
			}
		}
		System.out.println(time);
		
		
	}
}
