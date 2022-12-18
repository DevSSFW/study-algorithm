package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 { //동전 0
	private static int N, K;
	private static int[] coin;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		for(int i = 0; i < N; i++) coin[i] = Integer.parseInt(br.readLine());
		
		System.out.println(solve(N, 0));
	}
	public static int solve(int n, int count) {
		int size = n - 1, ans = count;
		
		if(K < coin[size]) return solve(size, ans); //남은 돈이 현재 돈보다 작으면 n - 1
		else {
			while(K >= coin[size]) { //남은 돈이 현재 돈보다 작아질 때까지 계속 뺀다.
				K -= coin[size];
				ans++;
			}
			
			if(K == 0) return ans;
			else return solve(size, ans);
		}
	}
}