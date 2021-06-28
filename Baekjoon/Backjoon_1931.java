import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_1931 {

	static public class Meet implements Comparable<Meet> {
		int start;
		int end;

		Meet() {
		}

		Meet(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meet o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			
			return this.end - o.end;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int num;
		int start, end=0;
		int cnt = 0;
		boolean use = false;

		List<Meet> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < num; i++) { //입력 처리
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken(" "));
			end = Integer.parseInt(st.nextToken(" "));
			list.add(new Meet(start, end));
		}

		Collections.sort(list); //end가 큰 것부터 내림차순 정렬

		for (int i = 0; i < num; i++) {			
				if(i!=0 && list.get(i).start < end) continue; //현재 범위를 벗어나면 다음 냉장고 확인
				else {
					end = list.get(i).end;
					cnt++;
				}
			}
		
		System.out.println(cnt);

		}
	
	
}
