import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1325 {

	static int N, M;
	static ArrayList<Integer> graph[];
	static boolean visit[];
	static int depth[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int from, to;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		graph = new ArrayList[N+1];
		depth = new int[N+1];


		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken(" "));
			to = Integer.parseInt(st.nextToken(" "));

			graph[from].add(to);
		}
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N+1];
			visit[i] = true;
			DFS(i);
		}
		
		int result=0;
		for(int i=1;i<=N;i++) {
			result = Math.max(result,depth[i]);
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 1; i <= N; i++) {
			if (depth[i] == result)
				sb.append(i).append(" ");
		}
		System.out.println(sb.toString());

	}

	static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int num : graph[now]) {
				if (visit[num]==false) {
					visit[num] = true;
					++depth[num];	
					q.add(num);
				}
			}

		}


	}
	
	static void DFS(int idx) {
		
		for(int num : graph[idx]) {
			if(visit[num]) continue;
			visit[num] = true;
			++depth[num];
			DFS(num);
		}
	}
	

}
