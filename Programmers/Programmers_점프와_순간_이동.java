
public class Programmers_점프와_순간_이동 {
	public static void main(String[] args) {
		System.out.println(solution(5000));
	}
	
    static public int solution(int n) {
        int ans = 0;

        
        while(n!=0) {
        	if(n%2 != 0) {
        		ans++;
        	}
        	n /= 2;
        }
        
        
        return ans;
    }
}
