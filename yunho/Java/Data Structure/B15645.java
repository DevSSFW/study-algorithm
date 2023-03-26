package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15645 { //내려가기 2
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int min_one = 0, min_two = 0, min_three = 0;
		int max_one = 0, max_two = 0, max_three = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			int one, two, three;
			
			one = Math.min(min_one, min_two) + n1;
			two = Math.min(Math.min(min_one, min_two), min_three) + n2;
			three = Math.min(min_two, min_three) + n3;
		
			min_one = one;
			min_two = two;
			min_three = three;
			
			one = Math.max(max_one, max_two) + n1;
			two = Math.max(Math.max(max_one, max_two), max_three) + n2;
			three = Math.max(max_two, max_three) + n3;
		
			max_one = one;
			max_two = two;
			max_three = three;
		}
		
		System.out.println(Math.max(Math.max(max_one, max_two), max_three) + " " + Math.min(Math.min(min_one, min_two), min_three));
	}
}