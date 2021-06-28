import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2851 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] result = new int[10];
		int ans=0;
		
		int num;
		for(int i=0;i<10;i++){
			num = Integer.parseInt(br.readLine());
			result[i] = 0;
			for(int j=0;j<=i;j++) {
				result[j] += num;
				if(Math.abs(result[j]-100) < Math.abs(ans-100)) {				
					ans = result[j];
				} else if(Math.abs(result[j]-100) == Math.abs(ans-100)) {
					ans = result[j] > ans ? result[j] : ans;
				}
			}			
		}
		//for(int i=0;i<10;i++)System.out.println(result[i]);
		
		System.out.println(ans);
	}

	
}
