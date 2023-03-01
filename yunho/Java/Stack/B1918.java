package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918 { //후위 표기식
	static StringBuilder sb = new StringBuilder();
	static Stack<Character> S = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c >= 'A' && c <= 'Z') sb.append(c);
			else if(c == ')') solve();
			else if(S.isEmpty() || c == '(') S.add(c);
			else if(c == '*' || c == '/') {
				while(!S.isEmpty()) {
					char top = S.peek();
					
					if(top == '(' || top == '+' || top == '-') break;
					sb.append(S.pop());
				}

				S.add(c);
			}
			else {
				while(!S.isEmpty()) {
					char top = S.peek();
					
					if(top == '(') break;
					sb.append(S.pop());
				}
				
				 S.add(c);
			}
		}
		
		while(!S.isEmpty()) {
			char top = S.pop();
			
			if(top == '(') continue;
			sb.append(top);
		}
		
		System.out.println(sb);
	}

	static void solve() {
		while(!S.isEmpty()) {
			char top = S.pop();
			
			if(top == '(') break;
			sb.append(top);
		}
	}
}