package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11051 { //이항 계수 2
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[1001][1001];
		dp[0][0] = 1;
		for(int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
			
			for(int j = 1; j < i; j++) dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
		}
		
		System.out.println(dp[N][K]);
	}
}