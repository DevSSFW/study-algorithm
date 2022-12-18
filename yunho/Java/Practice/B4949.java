package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4949 { //±ÕÇüÀâÈù ¼¼»ó

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		while(!s.equals(".")) {
			Stack<Character> S = new Stack<>();
			boolean isAns = true;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if(c == '[' || c == '(') {
					S.push(c);
					continue;
				}
				else if(c == ']') {
					if(S.size() == 0) {
						isAns = false;
						break;
					}
					char temp = S.pop();
					if(temp != '[') {
						isAns = false;
						break;
					}
				}
				else if(c == ')') {
					if(S.size() == 0) {
						isAns = false;
						break;
					}
					char temp = S.pop();
					if(temp != '(') {
						isAns = false;
						break;
					}
				}
			}
			if(!isAns || !S.isEmpty()) System.out.println("no");
			else System.out.println("yes");
			s = br.readLine();
		}
	}
}