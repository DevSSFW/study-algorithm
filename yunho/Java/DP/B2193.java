package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2193 { //ÀÌÄ£¼ö
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[91];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i < N; i++) dp[i] = dp[i - 2] + dp[i - 1];
		
		System.out.println(dp[N - 1]);
	}
}