package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912 { //¿¬¼ÓÇÕ
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		int sum = 0;
		dp[0] = -1001;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num >= 0 || sum > Math.abs(num)) sum += num;
			else sum = 0;
			
			dp[i] = Math.max(dp[i - 1], num);
			if(sum > 0) dp[i] = Math.max(dp[i - 1], sum);
		}
		
		System.out.println(dp[N]);
	}
}