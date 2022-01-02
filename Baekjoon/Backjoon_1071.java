import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_1071 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] check = new int[1002];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			check[arr[i]]++;
		}

		int flag = 0;

		for (int i = 0; i <= 1000; i++) {

			if (check[i] == 0)
				continue;

			int cur = i;
			flag = 0;
			if (check[i + 1] == 0) {
				for (int j = 0; j < check[i]; j++) {
					sb.append(cur).append(" ");
				}
				check[i] = 0;
			} else {
				for (int j = i + 2; j <= 1000; j++) {
					if (check[j] != 0) {
						flag = j;
						break;
					}
				}

				if (flag != 0) {
					for (int j = 0; j < check[i]; j++) {
						sb.append(cur).append(" ");
					}
					check[i] = 0;
					check[flag]--;
					sb.append(flag).append(" ");

				} else {

					for (int j = 0; j < check[cur + 1]; j++) {
						sb.append(cur + 1).append(" ");
					}
					check[cur + 1] = 0;
					for (int j = 0; j < check[i]; j++) {
						sb.append(cur).append(" ");
					}
					check[cur] = 0;
				}
			}

		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
}
