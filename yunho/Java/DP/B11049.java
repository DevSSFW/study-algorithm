package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11049 { //Çà·Ä °ö¼À ¼ø¼­
	static int[][] map, dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) dp[i][j] = 0;
				else dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j + i < N; j++) cal(j, j + i);
		}
		
		System.out.println(dp[0][N - 1]);
	}
	
	static void cal(int start, int end) {
		for(int i = start; i < end; i++) dp[start][end] = Math.min(dp[start][end], dp[start][i] + dp[i + 1][end] + map[start][0] * map[i][1] * map[end][1]);
	}
}