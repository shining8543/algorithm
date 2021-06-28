import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon_16118 {

	static public class Node implements Comparable<Node> {
		int index;
		long weight;
		int type;

		Node(int index, long weight) {
			this.index = index;
			this.weight = weight;
		}

		Node(int index, long weight, int type) {
			this.index = index;
			this.weight = weight;
			this.type = type;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.weight, weight);
		}
	}

	static List<Node> edge[] = new ArrayList[4000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N, M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < N; i++) {
			edge[i] = new ArrayList();
		}

		int from, to, weight;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken(" ")) - 1;
			to = Integer.parseInt(st.nextToken(" ")) - 1;
			weight = Integer.parseInt(st.nextToken(" "));

			edge[from].add(new Node(to, weight * 2));
			edge[to].add(new Node(from, weight * 2));

		}

		dijkstra(N, M);

	}

	static public void dijkstra(int N, int M) {

		long fox_result[] = new long[N];
		long wolf_result[][] = new long[2][N];

		PriorityQueue<Node> fox_pq = new PriorityQueue();

		for (int i = 0; i < N; i++) {
			fox_result[i] = 800000000;
			wolf_result[0][i] = 800000000;
			wolf_result[1][i] = 800000000;
		}

		fox_pq.add(new Node(0, 0));
		Node now_node;
		int now;
		long dist;
		fox_result[0] = 0;
		while (!fox_pq.isEmpty()) {
			now_node = fox_pq.poll();
			now = now_node.index;
			dist = now_node.weight;

			if (fox_result[now] < dist)
				continue;
			for (Node node : edge[now]) {
				if (fox_result[now] + node.weight < fox_result[node.index]) {
					fox_result[node.index] = fox_result[now] + node.weight;
					fox_pq.add(new Node(node.index, fox_result[node.index]));
				}
			}

		}
		PriorityQueue<Node> wolf_pq = new PriorityQueue();

		wolf_pq.add(new Node(0, 0, 0));
		int type;
		int next_type;
		wolf_result[0][0] = 0;
		while (!wolf_pq.isEmpty()) {
			now_node = wolf_pq.poll();
			now = now_node.index;
			dist = now_node.weight;
			type=  now_node.type;
			next_type = -(type-1);
			if (wolf_result[type][now] < dist)
				continue;
			for (Node node : edge[now]) {
				long weight = type == 0 ? node.weight/2 : node.weight*2;
				if (wolf_result[type][now] + weight < wolf_result[next_type][node.index]) {
					wolf_result[next_type][node.index] = wolf_result[type][now] + weight;					
					wolf_pq.add(new Node(node.index, wolf_result[next_type][node.index], next_type));
				}
			}
			


		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			//System.out.println(fox_result[i]+" "+wolf_result[0][i]+" "+wolf_result[1][i]);
			if (fox_result[i] < Math.min(wolf_result[0][i],wolf_result[1][i]))
				cnt++;
		}

		System.out.println(cnt);

	}

}
