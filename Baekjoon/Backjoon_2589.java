import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2589 {

	static class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int map_x, map_y;
	static char map[][] = new char[50][50];
	static int result;

	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;

		List<Node> list = new ArrayList();

		st = new StringTokenizer(br.readLine());

		map_x = Integer.parseInt(st.nextToken(" "));
		map_y = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < map_x; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken(" ");
			for (int j = 0; j < map_y; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'L')
					list.add(new Node(i, j));
			}
		}
		// 입력 끝

		for (int i = 0; i < list.size(); i++) {
			seek(list.get(i));
		}
		
		System.out.println(result);

	} // main-end

	static void seek(Node start) {
		Queue<Node> q = new LinkedList();
		int x, y, time, q_size;
		char t_map[][] = new char[map_x][map_y];
		Node now;

		for (int i = 0; i < map_x; i++) {
			for (int j = 0; j < map_y; j++)
				t_map[i][j] = map[i][j];
		} // 이동 확인용 배열

		q.add(start);
		t_map[start.i][start.j]= 'W'; 
		time = 0;

		while (!q.isEmpty()) {
			q_size = q.size();
			result = Math.max(result, time);
			for (int qs = 0; qs < q_size; qs++) {
				now = q.poll();

				for (int d = 0; d < 4; d++) {
					x = now.i + ni[d];
					y = now.j + nj[d];
					
					if(x < 0 || y < 0 || x>= map_x || y>= map_y) continue;
					
					if(t_map[x][y]!='W') {
						q.add(new Node(x,y));
						t_map[x][y] = 'W';
					}
				}
			}
			time++;
			
		}

	}

}
