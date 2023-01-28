package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B1793 { //≈∏¿œ∏µ
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		BigInteger[] dp = new BigInteger[251];
		
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		
		for(int i = 2; i <= 250; i++) {
			dp[i] = new BigInteger("0");
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));		
		}
		
		String num;
		while((num = br.readLine()) != null) sb.append(dp[Integer.parseInt(num)].toString() + '\n');	
			
		System.out.println(sb);
	}
}