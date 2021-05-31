import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14888 {
	static int max,min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num[];
		int symbol[] = new int[4];
		int select[];
		int N;
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken(" "));				
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++) {
			symbol[i] = Integer.parseInt(st.nextToken(" "));
		}
		select = new int[N-1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		combine(num,symbol, select,0,N,0);
		
		System.out.println(max);
		System.out.println(min);
		
		
	}
	
	static void combine(int[] num, int symbol[],int select[],int idx,int N,int cnt) {
		if(cnt==N-1) {
			int result=num[0];
			for(int i=0;i<N-1;i++) {
				if(select[i]==0) {
					result+=num[i+1];
				}else if(select[i]==1) {
					result-=num[i+1];
				}else if(select[i]==2) {
					result*=num[i+1];
				}else if(select[i]==3) {
					result/=num[i+1];
				}
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(symbol[i]!=0) {
				symbol[i]--;
				select[idx]=i;
				combine(num,symbol,select,idx+1,N,cnt+1);
				symbol[i]++;
			}
		}
		
		
		
	}
	
}
