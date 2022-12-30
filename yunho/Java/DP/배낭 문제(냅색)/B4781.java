package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4781 { //사탕 가게

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		while(!str.equals("0 0.00")) {
			StringTokenizer st = new StringTokenizer(str);
			
			int n = Integer.parseInt(st.nextToken());
			int m = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
			
			int[] dp = new int[m + 1]; //0부터 m * 100까지
			int[] cal = new int[n + 1], price = new int[n + 1];
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(st.nextToken());
				int p = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
				
				cal[i] = c;
				price[i] = p;
			}
			
			for(int i = 1; i <= n; i++) {
				for(int j = price[i]; j <= m; j++) dp[j] = Math.max(dp[j], dp[j - price[i]] + cal[i]);
			}
			
			sb.append(dp[m]).append('\n');
			
			str = br.readLine();
		}
		
		System.out.println(sb);
	}
}