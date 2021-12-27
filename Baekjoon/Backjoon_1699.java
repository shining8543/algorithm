import java.util.Scanner;

public class Backjoon_1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = solution(n);
		System.out.println(answer);
	}
    
        static public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++) {
        	dp[i] = i;
        	
        	for(int j=1;j*j <= i; j++) {
        		if(dp[i] > dp[i-j*j]+1) {
        			dp[i] = dp[i-j*j]+1;
        		}
        	}	        	
        }
                                
        return answer = dp[n];
    }
    
    
}