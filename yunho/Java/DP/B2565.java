package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2565 { //ภüฑ๊มู
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[][] E = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			E[i][0] = Integer.parseInt(st.nextToken());
			E[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(E, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { return o1[0] - o2[0]; }
		});
		
		for(int i = N - 1; i >= 0; i--) {
			dp[i] = 1;
			
			for(int j = i; j < N; j++) {
				if(E[i][1] < E[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) max = Math.max(max, dp[i]);
	
		System.out.println(N - max);
	}
}