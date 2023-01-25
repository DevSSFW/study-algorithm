package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1699 { //Á¦°ö¼öÀÇ ÇÕ
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[100001];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1; i <= 100000; i++) {
			int n = (int)Math.sqrt(i);
			
			if(n * n == i) {
				dp[i] = 1; //Á¦°ö¼ö
				continue;
			}
			
			for(int j = 1; j * j <= i; j++) dp[i] = Math.min(dp[i], dp[i - j * j] + dp[j * j]);
		}
		
		System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}