import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Backjoon_10165 {
	
	static public class Node implements Comparable<Node>{
		int num1, num2, pos;
		Node(int num1, int num2, int pos){
			this.num1 = num1;
			this.num2 = num2;
			this.pos = pos;
		}
		
		
		@Override
		public int compareTo(Node o) {
			
			if(this.num1 == o.num1) {
				return o.num2 - this.num2;
			}
			
			return this.num1 - o.num1;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		
		List<Node> pq = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		boolean[] remain = new boolean[M];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken(" "));
			int end = Integer.parseInt(st.nextToken(" "));
			
			if(start < end) {
				pq.add(new Node(start,end,i));
			}
			else {
				pq.add(new Node(start - N, end, i));
				pq.add(new Node(start, end+N,i));
			}
			set.add(i+1);
		}
		
		
		PriorityQueue<Node> run = new PriorityQueue<>();
		
		Collections.sort(pq);
		
		for(Node now : pq) {		
			
			if(remain[now.pos]) {
				continue;
			}
			
			while(!run.isEmpty() && now.num2 > run.peek().num1) {
				run.poll();
			}

			if(!run.isEmpty()) {				
				remain[now.pos] = true;
				continue;
			}	

			
			run.add(new Node(now.num2, now.num1, now.pos));
			
		}
		
		StringBuilder sb = new StringBuilder();
		

		
		for(int i=0;i<M;i++) {
			if(remain[i]) {
				continue;
			}
			sb.append(i+1).append(" ");
		}
		
		System.out.println(sb);
		
		
	}
}
