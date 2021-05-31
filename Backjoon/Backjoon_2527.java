// 백준 2527 직사각형
// 주소 : https://www.acmicpc.net/problem/2527

// ㅅㅂ오타 땜에 존나 헤맸다. p q xy 12 망할탱
// 앞으로 이름을 안 헷갈리게 쓰자. 오타난거 찾기 겁내 힘들다 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2527 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x1,y1,p1,q1,x2,y2,p2,q2;
		
		for(int t=0;t<4;t++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken(" "));
			y1 = Integer.parseInt(st.nextToken(" "));
			p1 = Integer.parseInt(st.nextToken(" "));
			q1 = Integer.parseInt(st.nextToken(" "));
			x2 = Integer.parseInt(st.nextToken(" "));
			y2 = Integer.parseInt(st.nextToken(" "));
			p2 = Integer.parseInt(st.nextToken(" "));
			q2 = Integer.parseInt(st.nextToken(" "));
			
			
			if( (x1 > p2 || y1 > q2) || (p1 < x2 || q1 < y2))
				System.out.println("d");
			
			else if((x1==p2 && y1 ==q2)||(x1==p2 && q1==y2) || (p1==x2 && y1==q2)|| (p1==x2 && q1 == y2))
					System.out.println("c");
				
	
			else if(x1==p2 || p1==x2 || q1==y2 || y1 == q2)
				System.out.println("b");
			
			
			else
				System.out.println("a");
						
			
			
		}
		
		
		
		
	}
}

