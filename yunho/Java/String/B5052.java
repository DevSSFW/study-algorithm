package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5052 { //전화번호 목록
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Loop : while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			String[] phone_book = new String[N];
			for(int i = 0; i < N; i++) phone_book[i] = br.readLine();
			Arrays.sort(phone_book);
			
			for(int i = 1; i < N; i++) {
				int len1 = phone_book[i - 1].length();
				int len2 = phone_book[i].length();
				
				if(len1 > len2 && phone_book[i - 1].substring(0, len2).equals(phone_book[i])) {
					sb.append("NO\n");
					continue Loop;
				}
				
				if(len1 <= len2 && phone_book[i].substring(0, len1).equals(phone_book[i - 1])){
					sb.append("NO\n");
					continue Loop;
				}
			}
			
			sb.append("YES\n");
		}
		
		System.out.println(sb);
	}
}