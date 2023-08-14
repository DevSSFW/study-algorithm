package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1032 { //명령 프롬프트
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] files = new String[N];
		for(int i = 0; i < N; i++) files[i] = br.readLine();
	
		for(int i = 0; i < files[0].length(); i++) {
			char c = files[0].charAt(i);
			
			for(int j = 1; j < N; j++) {
				if(c != files[j].charAt(i)) {
					c = '?';
					break;
				}
			}
			
			sb.append(c);
		}
		System.out.println(sb);
	}
}