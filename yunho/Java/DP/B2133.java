package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2133 { //타일 채우기
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[31];
		
		dp[0] = 1;
		dp[2] = 3;
		
		for(int i = 4; i <= 30; i += 2) {
			dp[i] = dp[i - 2] * dp[2];
			
			for(int j = i - 4; j >= 0; j -= 2) dp[i] += dp[j] * 2;
		}
		
		System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}