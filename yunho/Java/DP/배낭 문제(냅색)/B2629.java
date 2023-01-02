package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2629 { //¾çÆÈÀú¿ï
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		boolean[] dp = new boolean[40001];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			max += weight[i];
		}
		
		dp[0] = true;
		
		for(int i = 0; i < N; i++) {
			for(int j = max; j >= weight[i]; j--) {
				if(dp[j - weight[i]]) dp[j] = true;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		char[] ans = new char[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int marble = Integer.parseInt(st.nextToken());
			
			if(marble > 15000) {
				ans[i] = 'N';
				continue;
			}
			
			for(int j = 0; j <= max; j++) {
				if(dp[j] && dp[j + marble]) {
					ans[i] = 'Y';
					break;
				}
				else ans[i] = 'N';
			}
		}
		
		for(int i = 0; i < M; i++) System.out.print(ans[i] + " ");
	}
}