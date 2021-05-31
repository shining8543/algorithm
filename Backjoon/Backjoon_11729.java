import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_11729 {
	static StringBuilder sb =new StringBuilder();
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int num;

		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken(" "));

		hanoi(1, 2, 3, num);
		System.out.println(cnt);
		System.out.println(sb);
	}

	static void hanoi(int left, int mid, int right, int n) {

		if (n == 1) {
			cnt++;
			sb.append(left).append(" ").append(right).append("\n");
		} else {
			hanoi(left, right, mid, n - 1);
			cnt++;
			sb.append(left).append(" ").append(right).append("\n");
			hanoi(mid, left, right, n - 1);
		}

	}
}
