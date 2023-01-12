package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW15758 { //무한 문자열
	 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			
			sb.append('#').append(i).append(' ');
			if(Solve(st.nextToken(), st.nextToken())) sb.append("yes");
			else sb.append("no");
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	public static boolean Solve(String str1, String str2) {
		if(str2.length() > str1.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		
		for(int i = str1.length() - 1, j = str2.length() - 1; i >= 0; i--, j--) {
			if(j < 0) j = str2.length() - 1;
			if(str1.charAt(i) != str2.charAt(j)) return false;
		}
		
		return true;
	}
}