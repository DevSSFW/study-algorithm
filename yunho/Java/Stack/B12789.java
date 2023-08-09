package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B12789 { //도키도키 간식드리미
	static int order = 1;
	static Stack<Integer> S = new Stack<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			if(num[i] == order) {
				order++;
				continue;
			}
			
			check_stack();
			S.push(num[i]);
		}
		
		check_stack();
		
		if(S.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");
	}
	
	static void check_stack() {
		while(!S.isEmpty()) {
			int cur = S.peek();
			
			if(cur != order) break;
			
			order++;
			S.pop();
		}
	}
}