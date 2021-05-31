import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_6416 {

	static boolean used[] = new boolean[10001];
	static int parent_cnt[] = new int[10001];
	static int line_cnt;
	static Queue<Integer> q = new LinkedList();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int num1, num2;
		int temp_num;
		int t = 1;

		while (true) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			if (num1 == 0 && num2 == 0) {			
				
				if(isTree()) {
					System.out.println("Case "+t+" is a tree.");
				}else {
					System.out.println("Case "+t+" is not a tree.");
				}
				while(!q.isEmpty()) {
					temp_num = q.poll();
					used[temp_num] = false;
					parent_cnt[temp_num] =0;
				}
				line_cnt=0;
				t++;
			} else if (num1 == -1 && num2 == -1) {
				break;
			}

			else {
				if (!used[num1]) {
					q.add(num1);
					used[num1] = true;
				}
				if (!used[num2]) {
					q.add(num2);
					used[num2] = true;
				}
				line_cnt++;
				parent_cnt[num2]++;

			}

		}

	}
	
	static boolean isTree() {
		int num;
		int root=-1;
		int q_size = q.size();
		
		if(q_size == 0) return true;
		//비어있는 것도 트리로 간주
		
		if(line_cnt+1 != q_size ) return false;
		//간선 +1 과 정점이 같지 않으면 트리가 아님
		
		for(int i=0;i<q_size;i++) {
			num = q.poll();
			if(parent_cnt[num]==0) {
				if(root!=-1) return false;
				root = num;
			}
			//단 하나의 루트가 존재하는지 확인
			if(parent_cnt[num]>1) return false;
			//부모 노드가 1개 이상이면 트리가 아님
			q.add(num);
		}
		
		
		
		
		
		
		return true;
	}
	
	
	
}
