package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17845 { //���� ����
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[] I = new int[K], T = new int[K], dp = new int[N + 1];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			I[i] = Integer.parseInt(st.nextToken());
			T[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			for(int j = N; j >= T[i]; j--) dp[j] = Math.max(dp[j], dp[j - T[i]] + I[i]);
		}
		
		System.out.println(dp[N]);
	}
}