package Practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class use_PriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] num = new int[N][2];
		//Node를 사용한 올림차순
		PriorityQueue<Node> PQ1 = new PriorityQueue<>();
		//int[]를 사용한 내림차순
		PriorityQueue<int[]> PQ2 = new PriorityQueue<>((a, b) -> { return b[1] - a[1]; });
		for(int i = 0; i < N; i++) {
			num[i][0] = sc.nextInt(); num[i][1] = sc.nextInt();
			PQ1.add(new Node(num[i][0], num[i][1]));
			PQ2.add(new int[] {num[i][0], num[i][1]});
		}
		
		while(!PQ1.isEmpty()) {
			Node cur = PQ1.remove();
			
			System.out.println("PQ1		num : " + cur.num + "		count : " + cur.count);
		}
		System.out.println();
		while(!PQ2.isEmpty()) {
			int[] cur = PQ2.remove();
			
			System.out.println("PQ2		num : " + cur[0] + "		count : " + cur[1]);
		}
	}
	
	static class Node implements Comparable<Node> {
		int num, count;
		
		Node(int num, int count) {
			this.num = num;
			this.count = count;
		}
		
		public int compareTo(Node tar) {
			return this.count - tar.count;
			//return this.count >= tar.count ? 1 : -1;
		}
	}
}