import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_3190 {
	static class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Movement {
		int time;
		char dir;

		Movement() {
		}

		Movement(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}

	static int N;

	static int ni[] = { -1, 0, 1, 0 };
	static int nj[] = { 0, 1, 0, -1 };
	static List<Node> snake = new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int apple_cnt, movement_cnt;
		int x, y, time;
		char dir;
		int arr[][];
		Queue<Movement> move = new LinkedList();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		arr = new int[N][N];

		st = new StringTokenizer(br.readLine());
		apple_cnt = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < apple_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken(" ")) - 1;
			y = Integer.parseInt(st.nextToken(" ")) - 1;
			arr[x][y] = 1;
		}

		st = new StringTokenizer(br.readLine());
		movement_cnt = Integer.parseInt(st.nextToken(" "));

		for (int i = 0; i < movement_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken(" "));
			dir = st.nextToken(" ").charAt(0);
			move.add(new Movement(time, dir));
		}
		
		
		
		int t = 0;
		int now_dir = 1; // 처음 시작 오른쪽 방향을 보고 시작
		arr[0][0] = -1;
		snake.add(new Node(0, 0));
		Node head, tail;

		while (true) {
			t++;

		
		

			head = snake.get(0);
			tail = snake.get(snake.size() - 1);

			x = head.i + ni[now_dir];
			y = head.j + nj[now_dir];
			if (x < 0 || y < 0 || x >= N || y >= N || arr[x][y] == -1) {
				break;
			}
			if (arr[x][y] != 1) { // 사과가 아닌 경우 꼬리 삭제
				arr[tail.i][tail.j] = 0;
				snake.remove(snake.size() - 1);
			}

			snake.add(0, new Node(x, y));
			arr[x][y] = -1;

			
			if (!move.isEmpty() && t == move.peek().time) { // 방향을 바꿀 시간인 경우
				if (move.poll().dir == 'L') {
					now_dir = ( now_dir + 3 ) % 4;
				} else {
					now_dir = (now_dir+1)%4;
				}

			}
			
			
			
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("-------------");
//			
		}
		
		
		System.out.println(t);

	}
}
