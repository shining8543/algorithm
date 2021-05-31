import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1244번 스위치 켜고 끄기
//링크 : https://www.acmicpc.net/problem/1244


//남학생은 자기가 받은 수의 배수의 스위치를 모두 전환
//여학생은 자기가 받은 수를 중심으로 좌우가 계속 대칭인 구간까지 스위치를 전환


public class Backjoon_1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n; // 스위치 갯 수 100이하의 자연수
		int num; // 적힌 숫자
		boolean[] light = new boolean[101]; //사실 int를 쓰는게 시간복잡도가 좋은거 같은데 boolean을 썻다
		//c++ 에서는 true 출력하면 1로 나왔는데 힝...
		int temp=0;
		
		
		light[0] = true;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=1;i<=n;i++) {
			num = Integer.parseInt(st.nextToken(" "));
			if(num == 0) light[i] = false;
			else light[i] = true;
		}

	
		int person_count = Integer.parseInt(br.readLine());
		
		for(int i=0;i<person_count;i++) {
			st = new StringTokenizer(br.readLine()); 
			num = Integer.parseInt(st.nextToken(" "));
			if(num==1) { //남자 일 때
				num = Integer.parseInt(st.nextToken());
				for(int j=num; j<=n;j=j+num) {
					light[j] =!light[j];
				}
				
				
				
			}else { //여자 일 때
				num = Integer.parseInt(st.nextToken());
				light[num] =!light[num];
				temp = 1;
				while(temp>0) {
					if(num-temp > 0 && num+temp <= n) {
						if(light[num-temp] == light[num+temp]) {
							light[num-temp] = !light[num-temp];
							light[num+temp] = !light[num+temp];
						} else {
							temp = -1;
						}
					} else {
						temp = -1;
					}
					
					
					temp++;
				}
				

				
			}
			
			
		}
		int line=0;
		
		for(int i=1;i<n;i++) {
			if(light[i]) System.out.print("1 ");
			else System.out.print("0 ");
			line = (line+1)%20 ;
			if(line==0) System.out.println();
		}
		if(light[n]) System.out.print("1");
		else System.out.print("0");


		
	}
}
