package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501_2 { //Επ»η(DP)
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N], P = new int[N], dp = new int[N + 1];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		if(T[0] <= N) dp[T[0]] = P[0];
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			
			if(i + T[i] > N) continue;

			dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
		}
		
		System.out.println(Math.max(dp[N], dp[N - 1]));
	}
}