// 백준 2564 경비원
// 주소 : https://www.acmicpc.net/problem/2564

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2564 {
	
	static public class Node{
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i;
			this.j = j;			
		}
		
		
	}
	static Node dong;
	static Node shop[] = new Node[100];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
		
		int row,col;
		int result=0;
		int shop_cnt;
		
		int x,y;
		
		st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken(" "));
		col = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		shop_cnt = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<shop_cnt;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken(" "));
			y = Integer.parseInt(st.nextToken(" "));
			shop[i] = new Node(x,y);
		}
		st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken(" "));
		y = Integer.parseInt(st.nextToken(" "));
		dong = new Node(x,y);
		
		
		for(int i=0;i<shop_cnt;i++) {			
			switch(dong.i) {
			
			//북
			case 1:
				if(shop[i].i == 1) result+= Math.abs(dong.j-shop[i].j);
				else if(shop[i].i==2) {
					result+= Math.min(2*row - dong.j- shop[i].j, dong.j + shop[i].j) + col;
				}
				else if(shop[i].i==3) {
					result+= dong.j + shop[i].j;
					
				}else {
					result+= row - dong.j + shop[i].j;
				}
				
				
				break;
			//남
			case 2:
				if(shop[i].i == 1) 
					result+= Math.min(2*row - dong.j- shop[i].j, dong.j + shop[i].j) + col;
				else if(shop[i].i==2) 
					result+= Math.abs(dong.j-shop[i].j);
				
				else if(shop[i].i==3) 
					result+= dong.j + col - shop[i].j;
					
				else 
					result+= row - dong.j + col - shop[i].j;
				
				
				break;
			//서
			case 3:
				if(shop[i].i == 1) 
					result+= dong.j + shop[i].j;
					
				else if(shop[i].i==2) 
					result+= col-dong.j + shop[i].j;					
				
				else if(shop[i].i==3) 
					result+= Math.abs(dong.j - shop[i].j);
					
				else 
					result+= Math.min(dong.j + shop[i].j, 2*col - dong.j - shop[i].j) + col;	
				
				break;
			//동
			case 4:
				if(shop[i].i == 1) 
					result+= dong.j + row - shop[i].j;
					
				else if(shop[i].i==2) 
					result+= col-dong.j + row -  shop[i].j;					
				
				else if(shop[i].i==3) 
					result+= Math.min(dong.j + shop[i].j, 2*col - dong.j - shop[i].j) + col;
					
				else 
					result+= Math.abs(dong.j - shop[i].j);
				
				break;
				
			
			
			
			
			}
			
			
			
		}
		System.out.println(result);
		
		
	}
}
