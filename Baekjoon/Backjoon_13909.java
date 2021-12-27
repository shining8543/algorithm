import java.util.Scanner;

public class Backjoon_13909 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = solution(n);
		System.out.println(answer);
		
	}
	
    static public int solution(int n) {
        int answer = 0;
              
        
        for(int i=1;i*i<=n;i++) {
        	answer++;
        }

        return answer;
    }
}
