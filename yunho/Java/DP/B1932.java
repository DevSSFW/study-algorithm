package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1932 { //Á¤¼ö »ï°¢Çü
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] dp = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) dp[i] = new ArrayList<>();
		
		int res = 0;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < i; j++) {
				int num = Integer.parseInt(st.nextToken());
				int n1 = 0, n2 = 0;
				
				if(j != 0) n1 = dp[i - 1].get(j - 1);
				if(dp[i - 1].size() > j) n2 = dp[i - 1].get(j);
				
				num += Math.max(n1, n2);
				dp[i].add(num);
				
				res = Math.max(res, num);
			}
		}
		
		System.out.println(res);
	}
}