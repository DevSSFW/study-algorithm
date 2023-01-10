package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10844_1 { //쉬운 계단 수, 가장 큰 자릿수부터 시작(Top-Down)
	static int mod = 1000000000;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		
		//가장 작은 자릿수, 즉 일의 자릿수의 값
		for(int i = 0; i < 10; i++) dp[1][i] = 1;
		
		//가장 앞의 자릿값 1~9의 개수를 구한다.
		for(int i = 1; i < 10; i++) solve(N, i);
		
		long res = 0;
		for(int i = 1; i < 10; i++) res += dp[N][i];
		System.out.println(res % mod);
	}

	//가장 큰 자릿수에서 시작해서 일의 자릿수가 되면 재귀가 끝난다.
	//digit : 자릿수, num : 자릿값
	//자릿수가 일의 자리 숫자가 되면 재귀를 종료한다. 즉, digit가 1이 되면 종료한다.
	//dp[digit][num]을 구하지 않았다면, 재귀를 실행한다.
	//자릿값이 0이면 앞의 자릿값은 1이다.
	//자릿값이 9면 앞의 자릿값은 8이다.
	//자릿값이 1~8이면 앞의 자릿값은 (자릿값 - 1)과 (자릿값 + 1)이다.
	//반환값은 현재 자릿수까지의 선택한 숫자가 올 수 있는 개수(dp[digit][num])를 반환한다.
	public static int solve(int digit, int num) {
		if(digit == 1) return dp[digit][num];
		
		if(dp[digit][num] == 0) {
			if(num == 0) dp[digit][num] = solve(digit - 1, 1);
			else if(num == 9) dp[digit][num] = solve(digit - 1, 8);
			else dp[digit][num] = solve(digit - 1, num - 1) + solve(digit - 1, num + 1);
		}
		
		return dp[digit][num] % mod;
	}
}