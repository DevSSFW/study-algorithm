package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3067 { //Coins
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) coins[i] = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[10001];
			
			for(int i = 0; i < N; i++) {
				dp[coins[i]]++;
				
				for(int j = coins[i] + 1; j <= M; j++) dp[j] += dp[j - coins[i]];
			}
			
			sb.append(dp[M]).append('\n');
		}
		
		System.out.println(sb);
	}
}