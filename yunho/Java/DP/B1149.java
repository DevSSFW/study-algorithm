package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 { //RGB°Å¸®
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[3][N + 1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			dp[0][i] = Math.min(dp[1][i - 1] + R, dp[2][i - 1] + R);
			dp[1][i] = Math.min(dp[0][i - 1] + G, dp[2][i - 1] + G);
			dp[2][i] = Math.min(dp[0][i - 1] + B, dp[1][i - 1] + B);
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) res = Math.min(res, dp[i][N]);
		
		System.out.println(res);
	}
}