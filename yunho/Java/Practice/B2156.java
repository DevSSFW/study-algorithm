package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 { //포도주 시식

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] wine = new int[n + 2];
		for(int i = 0; i < n; i++) wine[i] = Integer.parseInt(br.readLine());
		
		int[] ans = new int[n + 2];
		
		ans[0] = wine[0]; ans[1] = wine[0] + wine[1];
		ans[2] = Math.max(Math.max(wine[0] + wine[2], wine[1] + wine[2]), ans[1]);
		for(int i = 3; i < n; i ++) {
			ans[i] = Math.max(ans[i - 2], ans[i - 3] + wine[i - 1]) + wine[i];
			ans[i] = Math.max(ans[i], ans[i - 1]);
		}
		
		System.out.println(ans[n - 1]);
	}
}