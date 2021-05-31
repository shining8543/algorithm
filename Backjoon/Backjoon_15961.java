import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_15961 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,d,k,c; // 접시 수, 초밥 가짓수, 연속해서 먹는 접시 수, 쿠폰 번호
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		d = Integer.parseInt(st.nextToken(" "));
		k = Integer.parseInt(st.nextToken(" "));
		c = Integer.parseInt(st.nextToken(" "));
		
		
		int arr[] = new int[N];
		int cnt[] = new int[d+1];
		
		int var=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());			
			arr[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		int result=0;
		
		for(int i=0;i<k;i++) {
			if(cnt[arr[i]]==0) var++;
			cnt[arr[i]]++;
			if(cnt[c]==0)
				result = Math.max(var+1, result);
			else
				result = Math.max(var, result);
		}
		
		
		
		for(int i=k;i<N;i++) {

			cnt[arr[i-k]]--;
			if(cnt[arr[i-k]]==0) var--;
			
			if(cnt[arr[i]]==0)var++;
			cnt[arr[i]]++;
			

			if(cnt[c]==0)
				result = Math.max(var+1, result);
			else
				result = Math.max(var, result);
			
		}
		
		for(int i=0;i<k-1;i++) {
			cnt[arr[(N-k)+i]]--;
			if(cnt[arr[(N-k)+i]]==0) var--;
			
			if(cnt[arr[i]]==0)var++;
			cnt[arr[i]]++;
			

			
			if(cnt[c]==0)
				result = Math.max(var+1, result);
			else
				result = Math.max(var, result);
			
		}
		
		
		
		System.out.println(result);
		
	}
}
