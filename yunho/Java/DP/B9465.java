package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465 { //��ƼĿ
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] num = new int[2][N + 1], dp = new int[2][N + 1];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 1; j <= N; j++) num[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = num[0][1];
			dp[1][1] = num[1][1];
			
			for(int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[0][i], Math.max(dp[1][i - 2], dp[1][i - 1]) + num[0][i]);
				dp[1][i] = Math.max(dp[1][i], Math.max(dp[0][i - 2], dp[0][i - 1]) + num[1][i]);
			}
			
			sb.append(Math.max(dp[0][N], dp[1][N])).append('\n');
		}
		
		System.out.println(sb);
	}
}