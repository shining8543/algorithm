
// 백준 10158 개미
// 주소 : https://www.acmicpc.net/problem/10158


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_10158 {
	

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int w,h;
		int ant_x, ant_y;
		int time;
		int result_x, result_y;
		
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ant_x = Integer.parseInt(st.nextToken());
		ant_y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		time = Integer.parseInt(st.nextToken());
		
		ant_x += time%(2*w);
		ant_y += time%(2*h);
		
		if(ant_x > w) {
			ant_x = Math.abs(ant_x - 2*w);
		}
		if(ant_y > h) {
			ant_y = Math.abs(ant_y - 2*h);
			
		}
		
		sb.append(ant_x).append(" ").append(ant_y);
		//sb.append(ant_x+" "+ant_y); 로 하면 시간초과가 나온다.
		System.out.println(sb);
						
	}
	
	
	
}
