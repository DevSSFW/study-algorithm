package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1343 { //폴리오미노
	public static StringBuilder sb = new StringBuilder();
	public static String str;
	public static int count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'X') count++;
			else if(str.charAt(i) == '.') {
				if(!solve()) return;
				sb.append('.');
			}
		}
		
		if(count > 0) {
			if(!solve()) return;
		}
		
		System.out.println(sb);
	}
	
	public static boolean solve() {
		if(count % 2 != 0) {
			System.out.println(-1);
			return false;
		}
		
		while(count >= 4) {
			count -= 4;
			sb.append("AAAA");
		}
		
		if(count == 2) {
			count -= 2;
			sb.append("BB");
		}
		
		return true;
	}
}