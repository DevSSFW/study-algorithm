package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9020 { //∞ÒµÂπŸ»Â¿« √ﬂ√¯
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] num = new int[10001];
		boolean[] vis = new boolean[10001];
		for(int i = 2; i <= 10000; i++) {
			if(vis[i]) continue;
			
			for(int j = i * 2; j <= 10000; j += i) vis[j] = true;
		}
		
		int[][] ans = new int[10001][2];
		for(int i = 4; i <= 10000; i++) {
			if(i % 2 != 0) continue;
			
			int n = i / 2;
			for(int j = n; j < i; j++) {
				if(vis[j] || vis[i - j]) continue;
				
				ans[i][0] = i - j;
				ans[i][1] = j;
				break;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(ans[n][0]).append(' ').append(ans[n][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}