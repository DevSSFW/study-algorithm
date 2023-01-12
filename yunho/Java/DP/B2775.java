package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2775 { //부녀회장이 될테야
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[K + 1][N + 1];
			
			for(int i = 1; i <= N; i++) dp[0][i] = i;
			for(int i = 1; i <= K; i++) {
				for(int j = 1; j <= N; j++) dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
			
			sb.append(dp[K][N]).append('\n');
		}
		
		System.out.println(sb);
	}
}