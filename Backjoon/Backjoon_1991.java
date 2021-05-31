import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_1991 {
	static class Node{
		char left, right;
		Node(){}
		Node(char left, char right){
			this.left =left;
			this.right =right;
		}
	}
	
	static Node graph[] = new Node[26];
	static StringBuilder preorder = new StringBuilder();
	static StringBuilder inorder = new StringBuilder();
	static StringBuilder postorder = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int from;
		char left, right;
		int N;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			from = st.nextToken().charAt(0) - 'A';
			left = st.nextToken().charAt(0);
			right = st.nextToken().charAt(0);
			graph[from] = new Node(left,right);			
		}
		DFS('A');
		
		System.out.println(preorder);
		System.out.println(inorder);
		System.out.println(postorder);
	}
	
	static void DFS(char idx) {
		int index = idx - 'A';
		
		preorder.append(idx);
		if(graph[index].left!='.')
			DFS(graph[index].left);
		inorder.append(idx);
		if(graph[index].right!='.')
			DFS(graph[index].right);
		postorder.append(idx);
	}
	
}
