import java.util.Scanner;

//백준 17148 재귀함수가 뭔가요? : https://www.acmicpc.net/problem/17478





public class Backjoon_17148 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n; // 1<= n <=50
		n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		WhatIsTheRecursive(n,0);

	}
	
	static void WhatIsTheRecursive(int n,int recursive_count) {
		
		if(n>recursive_count) {
			pleaseHelp(recursive_count);
			System.out.println("\"재귀함수가 뭔가요?\"");
			pleaseHelp(recursive_count);
			System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			pleaseHelp(recursive_count);
			System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			pleaseHelp(recursive_count);
			System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			WhatIsTheRecursive(n,++recursive_count);
			pleaseHelp(recursive_count);
			System.out.println("라고 답변하였지.");
		}
		else {
			pleaseHelp(recursive_count);
			System.out.println("\"재귀함수가 뭔가요?\"");
			pleaseHelp(recursive_count);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			pleaseHelp(recursive_count);
			System.out.println("라고 답변하였지.");
			
		}
		
	}
	
	static void pleaseHelp(int recursive_count) {
		if(recursive_count>0) {
			System.out.print("____");
			pleaseHelp(recursive_count-1);
		}
	}
	
	
}
