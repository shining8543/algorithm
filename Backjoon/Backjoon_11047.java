import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		
		int coin[];
		int N;
		int target;
		int cnt=0;
		int idx=1;
		int temp;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		target = Integer.parseInt(st.nextToken(" "));
		
		coin = new int[N];
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		while(target!=0) {
			if(target >= coin[N-idx]) {
				temp = target/coin[N-idx];
				cnt += temp;
				target -= coin[N-idx]*temp;
			}		
			idx++;
		}
		System.out.println(cnt);
		
	}
}
