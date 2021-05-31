import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1158 오세푸스
// 주소 : https://www.acmicpc.net/problem/1158
public class Backjoon_1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<Integer> q = new LinkedList();
		Queue<Integer> nq = new LinkedList();
		StringBuilder sb = new StringBuilder();
		
		int n,k;
		int cnt=0;
		int num;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken(" "));
		k = Integer.parseInt(st.nextToken(" "));
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		
		
		while(!q.isEmpty()) {
			cnt++;
			num = q.poll();
			if(cnt==k) {
				nq.offer(num);
				cnt = 0;
			} else {
				q.offer(num);
			}						
		}
		
		sb.append("<");
		sb.append(nq.poll());
		while(!nq.isEmpty()) {
			sb.append(", "+nq.poll());
		}
		sb.append(">");
		System.out.println(sb);
		
	}
	
	
}
