package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1535 { //�ȳ�
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N + 1], J = new int[N + 1], dp = new int[101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) L[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) J[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			for(int j = 100; j > L[i]; j--) dp[j] = Math.max(dp[j], dp[j - L[i]] + J[i]);
		}
		
		System.out.println(dp[100]);
	}
}