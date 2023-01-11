package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9184 { //신나는 함수 실행
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][][] dp = new int[21][21][21];
		for(int i = 0; i <= 20; i++) {
			for(int j = 0; j <= 20; j++) {
				dp[0][i][j] = 1;
				dp[i][0][j] = 1;
				dp[i][j][0] = 1;
			}
		}
		
		for(int i = 1; i <= 20; i++) {
			for(int j = 1; j <= 20; j++) {
				for(int k = 1; k <= 20; k++) {
					if(i < j && j < k) dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					else dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
				}
			}
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) break;
			
			int res = 0;
			if(a <= 0 || b <= 0 || c <= 0) res = 1;
			else if(a > 20 || b > 20 || c > 20) res = dp[20][20][20];
			else res = dp[a][b][c];
			
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(res).append('\n');
		}
		
		System.out.println(sb);
	}
}