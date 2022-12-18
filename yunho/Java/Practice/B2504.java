package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504 { //°ýÈ£ÀÇ °ª
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> S = new Stack<>();
		
		int res = 0, temp = 1;
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				S.add('(');
				temp *= 2;
			}
			else if(str.charAt(i) == '[') {
				S.add('[');
				temp *= 3;
			}
			else if(str.charAt(i) == ')') {
				if(S.size() == 0 || S.pop() == '[') {
					System.out.println(0);
					return;
				}
				
				if(str.charAt(i - 1) == '(') res += temp;
				temp /= 2;
			}
			else {
				if(S.size() == 0 || S.pop() == '(') {
					System.out.println(0);
					return;
				}
				
				if(str.charAt(i - 1) == '[') res += temp;
				temp /= 3;
			}
		}
		
		if(S.size() > 0) System.out.println(0);
		else System.out.println(res);
	}
}