package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2839 { //º≥≈¡ πË¥ﬁ
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1], num = new int[2];
		num[0] = 3; num[1] = 5;
		
		Arrays.fill(dp, 2000);
		dp[0] = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = num[i]; j <= N; j++) dp[j] = Math.min(dp[j], dp[j - num[i]] + 1);
		}
		
		if(dp[N] == 2000) System.out.println(-1);
		else System.out.println(dp[N]);
	}
}