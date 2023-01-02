package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14728 { //º­¶ôÄ¡±â
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
		int[] K = new int[N], S = new int[N], dp = new int[T + 1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = T; j >= K[i]; j--) dp[j] = Math.max(dp[j], dp[j - K[i]] + S[i]);
		}
		
		System.out.println(dp[T]);
	}
}