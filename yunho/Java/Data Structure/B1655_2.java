package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1655_2 { //����� ���ؿ� (�ڷᱸ��, �켱���� ť)

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> left = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<Integer>();

		int mid = 100000;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(left.size() == right.size()) {
				if(mid >= num) {
					left.add(num);
					mid = left.peek();
				}
				else {
					right.add(num);
					mid = right.peek();
				}
			}
			
			else {
				if(mid >= num) {
					if(left.size() > right.size()) right.add(left.remove());
					
					left.add(num);
					mid = left.peek();
				}
				else {
					if(left.size() < right.size()) left.add(right.remove());
					
					right.add(num);
					mid = left.peek();
				}
			}
			
			sb.append(mid + "\n");
		}
		
		System.out.println(sb);
	}
}