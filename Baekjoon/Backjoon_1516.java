import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1516 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] list = new ArrayList[N];
		int[] need = new int[N];
		int[] result = new int[N];
		int[] time = new int[N];
		
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken(" "));
			
			int num = Integer.parseInt(st.nextToken(" "));
			while(num != -1) {
				list[num-1].add(i);
				need[i]++;
				num = Integer.parseInt(st.nextToken(" "));
			}
			
		}
		
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			if(need[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : list[now]) {	
				
				need[next]--;
				result[next] = Math.max(result[next], result[now]+time[now]);
				
				if(need[next] == 0) {
					q.add(next);
				}
				
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(result[i]+time[i]);
		}
		
		
	}
}
