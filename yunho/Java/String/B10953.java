package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10953 { //A + B - 6
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			sb.append(str.charAt(0) - '0' + str.charAt(2) - '0').append('\n');
		}
		
		System.out.println(sb);
	}
}