import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_2437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		int arr[];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		
		List<Integer> num = new ArrayList();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			num.add(Integer.parseInt(st.nextToken(" ")));
		
		Collections.sort(num);
		
		
		
		int sum=1;
		for(int i=0;i<N;i++) {
			if(num.get(i) <= sum) {
				sum+= num.get(i);
			}
			else {
				break;
			}
		}
		
		System.out.println(sum);
		
		
	}
}
