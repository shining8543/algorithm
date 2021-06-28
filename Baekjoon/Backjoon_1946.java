// 백준 1946 신입 사원
// 주소 : https://www.acmicpc.net/problem/1946

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_1946 {
	
	static public class Node implements Comparable<Node>{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i; //성적
			this.j = j; //순위
		}
	
		public int compareTo(Node o) {	
			
			return this.i - o.i;
		}		
		
		
	}
	static List<Node> list = new ArrayList();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t_case;
		int volunteer_num ,cnt;
		int x,y;
		int cut_line;
		
		st = new StringTokenizer(br.readLine());
		t_case = Integer.parseInt(st.nextToken(" "));
		
		
		for(int t=0;t<t_case;t++) {
			st = new StringTokenizer(br.readLine());
			volunteer_num = Integer.parseInt(st.nextToken(" "));
			cnt = volunteer_num;
			for(int i=0;i<volunteer_num;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken(" "));
				y = Integer.parseInt(st.nextToken(" "));
				
				list.add(new Node(x,y));
			}
			
			Collections.sort(list);	
			// 성적이 적은순으로 정렬
			
			for(int i=0;i<volunteer_num;i++) {
				System.out.println(list.get(i).i + " " +list.get(i).j);
			
			}
			
			cut_line = list.get(0).j;
			for(int i=1;i<volunteer_num;i++) {
				if(cut_line < list.get(i).j) { 
					cnt--;
				} 
				cut_line = Math.min(cut_line, list.get(i).j);
				
			}
			// 순서대로 보면서 순위 더 낮은 사람이 있으면 수를 줄임
			// index가 뒤로 갈수록 성적이 더 낮다 (정렬했으므로), 순위도 낮다면 적어도 하나 이상 더 높은 사람이 있는 것이므로 조건에 부합하지 않다.
			// 커트라인 순위는 항상 최소값으로 바꿔준다.
			
		//System.out.println(cnt);	
		list.clear();
		
		}
		
	}
}
