package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B11478 { //서로 다른 부분 문자열의 개수
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		HashSet<String> S = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j <= str.length(); j++) {
				String temp = str.substring(i, j);
				
				if(!S.contains(temp)) S.add(temp);
			}
		}
		
		System.out.println(S.size());
	}
}