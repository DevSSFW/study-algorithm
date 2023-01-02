package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1106 { //хёез

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[] M = new int[N], customer = new int[N], dp = new int[1001];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			M[i] = Integer.parseInt(st.nextToken());
			customer[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0; i < N; i++) {
			for(int j = 1; j <= customer[i]; j++) dp[j] = Math.min(dp[j], M[i]);
			for(int j = customer[i] + 1; j <= C; j++) dp[j] = Math.min(dp[j], dp[j - customer[i]] + M[i]);
		}
		
		System.out.println(dp[C]);
	}
}