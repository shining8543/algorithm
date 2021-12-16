import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon_1708 {
	
	static class Node implements Comparable<Node> {
		long x,y;

		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node o) {		
			
			if(this.y == o.y) {
				if(this.x > o.x) {
					return 1;
				}
				return -1;
			}
			
			
			if(this.y > o.y) {
				return 1;
			}
			return -1;
		}		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Node> points = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken(" "));
			int y = Integer.parseInt(st.nextToken(" "));
			
			points.add(new Node(x,y));
			
		}
		
		Collections.sort(points);
		Node first = points.get(0);
		
		Collections.sort(points, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				int result = ccw(first,a,b);
				
				if(result > 0) {
					return -1;
				}else if(result < 0) {
					return 1;
				}
				
				long dist1 = dist(first,a);
				long dist2 = dist(first,b);
				
				
				if(dist1 > dist2)
					return 1;
				
				return -1;
				
				
				
			}
		});
		
		Stack<Node> stack = new Stack<>();
        stack.add(first);

        for (int i = 1; i < points.size(); i++) {
            while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) <= 0)) {    // first, second, next
                stack.pop();    // second 빼기
            }
            stack.add(points.get(i));    // next 넣기
        }

		System.out.println(stack.size());
		
	}
	
	
	
	static long dist(Node a, Node b) {
		return ((b.x - a.x) * (b.x-a.x))  + ((b.y - a.y) * (b.y-a.y));
	}
	
	static int ccw(Node a, Node b, Node c) {
		long result = (a.x*b.y + b.x*c.y + c.x*a.y) - (b.x*a.y + c.x*b.y + a.x*c.y);
		
		if(result > 0) {
			return 1;
		}else if(result < 0) {
			return -1;
		}
		
		return 0;
		
	}
	
	
}
