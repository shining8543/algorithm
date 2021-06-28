import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1464_BFS {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arr[] = new int[1000001];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		int N;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		Queue<Integer> q = new LinkedList();
		int q_size;
		int time=-1;
		
		q.add(N);
		
		int num;
		boolean visit[] = new boolean[N+1];
		
		
		while(!q.isEmpty()) {
			time++;
			q_size = q.size();
			for(int _q=0;_q<q_size;_q++) {
				num = q.poll();
				if(num==1) {
					q.clear();
					break;
				}
				
				if(num%3==0) {
					visit[num/3]=true;
					q.add(num/3);
				}
				if(num%2==0) {
					visit[num/2] = true;
					q.add(num/2);
				}
				if(num>1) {
					visit[num-1] = true;
					q.add(num-1);
				}				
			}
		}
		System.out.println(time);
	
		
	}
}
