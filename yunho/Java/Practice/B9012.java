package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9012 { //°ýÈ£

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			boolean ans = true;
			int count = 0, size = s.length();
			
			for(int j = 0; j < size; j++) {
				if(s.charAt(j) == '(') count++;
				else if(s.charAt(j) == ')') count--;
				if(count < 0) {
					ans = false;
					break;
				}
			}
			if(count != 0) ans = false;
			if(ans) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}