import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int student[][] = new int[2][7];
		int student_cnt, K;
		int sex, year;
		int room = 0;
		st = new StringTokenizer(br.readLine());
		student_cnt = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < student_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			sex = Integer.parseInt(st.nextToken(" "));
			year = Integer.parseInt(st.nextToken(" "));
			student[sex][year]++;
		}
		
		for(int i=0;i<2;i++) {
			for(int j=1;j<=6;j++) {
				if(student[i][j]%K == 0) room += student[i][j]/K;
				else room += student[i][j]/K + 1;
			}
		}
		System.out.println(room);

	}
}
