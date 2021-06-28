import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_16562 {
	static class Node{
		int head;
		int money;
		Node(){}
		Node(int head, int money){
			this.head = head;
			this.money = money;			
		}
	}
	
	static Node friend[];
	
	static int findHead(int n) {
		if(friend[n].head==n) return n;
		
		
		return friend[n].head = findHead(friend[n].head);
	}
	static boolean union(int a,int b) {
		int aRoot = findHead(a);
		int bRoot = findHead(b);
		if(aRoot == bRoot)
			return false;
		
		friend[bRoot].head = aRoot;
		friend[bRoot].money = Math.min(friend[aRoot].money, friend[bRoot].money);
		friend[aRoot].money = friend[bRoot].money;
		
		return true;
	}
	
	
	
	static int N,M,k; //친구 수, 관계 수, 돈
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num1,num2;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		k = Integer.parseInt(st.nextToken(" "));
		
		friend = new Node[N+1];
		int need;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {	
			friend[i] = new Node(i,Integer.parseInt(st.nextToken(" ")));
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken(" "));
			num2 = Integer.parseInt(st.nextToken(" "));
			union(num1,num2);
		}
		
		need = friend[findHead(1)].money;
		
		for(int i=2;i<=N;i++) {
			if(findHead(1)!=findHead(i)) {
				need += friend[findHead(i)].money;
				union(1,i);
			}
		}
		if(need<=k)
			System.out.println(need);
		else
			System.out.println("Oh no");
	}
}
