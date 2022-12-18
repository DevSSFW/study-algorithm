package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B9375 { //ÆÐ¼Ç¿Õ ½ÅÇØºó
	static int N, ans;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			map = new HashMap<>();
			N = Integer.parseInt(br.readLine());
			
			while(N-- > 0) {
				String[] s = br.readLine().split(" ");
				
				if(map.containsKey(s[1])) map.put(s[1], map.get(s[1]) + 1); 
				else map.put(s[1], 2);	
			}
			
			int count = 1;
			for(String s : map.keySet()) count *= map.get(s);
			count--;
			
			System.out.println(count);
		}
	}
}