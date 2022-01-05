import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N,L;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		L = Integer.parseInt(st.nextToken(" "));
		
		List<Integer> lines[] = new ArrayList[L+1];
		List<Integer> stations[] = new ArrayList[N+1];
		
		
		
		
		for(int i=1;i<=N;i++) {
			stations[i] = new ArrayList<>();
		}
		
		int idx = 1;
		for(int i=1;i<=L;i++) {
			st = new StringTokenizer(br.readLine());
			int num = 0;
			lines[i] = new ArrayList();
			while((num = Integer.parseInt(st.nextToken(" "))) != -1) {
				lines[i].add(num);
				stations[num].add(i);
			}
		}
		
		int start,end;
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken(" "));
		end = Integer.parseInt(st.nextToken(" "));
		
		
		
		boolean[] visited = new boolean[N+1];
		boolean[] visitedLine = new boolean[L+1];
		Queue<Integer> q = new LinkedList();
		
		visited[start] = true;
		
		for(int line : stations[start]) {
			q.add(line);
			visitedLine[line] = true;
		}
		
				
		int cnt = 0;
		while(!q.isEmpty()) {
			
			int q_size = q.size();
			for(int _q=0;_q<q_size;_q++) {
				int now = q.poll();
				
				for(int num : lines[now]) {
					if(visited[num]) continue;
					visited[num] = true;
					for(int line : stations[num]) {
						if(visitedLine[line]) continue;
						q.add(line);
						visitedLine[line] = true;
					}					
				}
				
			
			}
			
			if(visited[end]) {
				break;
			}
			cnt++;
		}
		
		if(!visited[end]) System.out.println(-1);
		else System.out.println(cnt);
		
	}
}

