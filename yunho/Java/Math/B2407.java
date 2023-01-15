package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2407 { //а╤гу
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		BigInteger[][] dp = new BigInteger[101][101];
		
		for(int i = 0; i <= 100; i++) {
			for(int j = 0 ; j <= 100; j++) dp[i][j] = new BigInteger("0");
		}
		
		for(int i = 0; i <= 100; i++) {
			dp[i][0] = BigInteger.valueOf(1);
			dp[i][i] = BigInteger.valueOf(1);
		}
		
		for(int i = 2; i <= 100; i++) {
			for(int j = 1; j < i; j++) dp[i][j] = dp[i - 1][j].multiply(BigInteger.valueOf(i)).divide(BigInteger.valueOf(i - j));
		}
		
		System.out.println(dp[N][M]);
	}
}