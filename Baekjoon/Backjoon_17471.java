import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_17471 {
	
	static int N;
	static int arr[];
	static List<Integer> edge[];
	static boolean choice[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int edge_cnt;
		int v;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		
		arr = new int[N];
		edge = new List[N];
		choice = new boolean[N];
		
		for(int i=0;i<N;i++) {
			edge[i] = new ArrayList();
		}
		
		st = new StringTokenizer(br.readLine());		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			edge_cnt = Integer.parseInt(st.nextToken(" "));
			
			for(int j=0;j<edge_cnt;j++) {
				v = Integer.parseInt(st.nextToken(" ")) - 1;
				edge[i].add(v);
			}
			
		}
		result = Integer.MAX_VALUE;
		simulate(0,0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
		
		
	}
	
	static void simulate(int idx,int cnt) {
		
						
		if(cnt!=0 && cnt!=N) {
			if(isConnect(cnt)) {
				int red = 0;
				int blue = 0;
				for(int i=0;i<N;i++) {
					if(choice[i]) red += arr[i];
					else blue+=arr[i];
					
				}
			
				
				result = Math.min(result, Math.abs(red-blue));
				
				
			}
			
			
			
		}
		
		if(cnt==N || idx==N) return;
		
		
		choice[idx] = true;
		simulate(idx+1, cnt+1);
		choice[idx] = false;
		simulate(idx+1,cnt);
		
		
		
		
		
	}
	
	static boolean isConnect(int cnt) {
		
		boolean visit[] = new boolean[N];
		int start_red=-1;
		int start_blue=-1;
		int now;
		int red_cnt, blue_cnt;
		
		for(int i=0;i<N;i++) {
			if(choice[i]) {
				start_red = i;
			}
		}
		
		for(int i=0;i<N;i++) {
			if(!choice[i]) {
				start_blue = i;
			}
		}
		
		Queue<Integer> q = new LinkedList();
		visit[start_red] = true;
		q.add(start_red);
		red_cnt =1;
		
		while(!q.isEmpty()) {
			
			now = q.poll();
			for(int n : edge[now]) {
				if(choice[n] && !visit[n]) {
					visit[n] = true;
					red_cnt++;
					q.add(n);
				}
			}			
		}
		
		if(red_cnt != cnt) return false;
		
		visit[start_blue] = true;
		q.add(start_blue);
		blue_cnt = 1;
		
		while(!q.isEmpty()) {
			now = q.poll();
			for(int n: edge[now]) {
				if(!choice[n] && !visit[n]) {
					visit[n] = true;
					blue_cnt++;
					q.add(n);
				}
			}
			
		}
		
		if(blue_cnt != N-cnt) return false;
		
		return true;
	}
	
}
