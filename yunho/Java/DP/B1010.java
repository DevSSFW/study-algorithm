package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010 { //다리 놓기
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[30][30];
		
		for(int i = 1; i < 30; i++) dp[1][i] = i;
		for(int i = 2; i < 30; i++) {
			for(int j = i; j < 30; j++) {
				for(int k = i - 1; k < j; k++) dp[i][j] += dp[i - 1][k];
			}
		}
		
		while(T-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
					
			sb.append(dp[N][M]).append('\n');
		}
		
		System.out.println(sb);
	}
}