package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10844_2 { //쉬운 계단 수, 일의 자릿수부터 시작(Bottom_Up)
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), mod = 1000000000;
		
		int[][] dp = new int[N + 1][10];
		
		//가장 큰 자릿수, 즉 가장 앞에 있는 숫자
		for(int i = 1; i < 10; i++) dp[1][i] = 1;

		//십의 자릿수에서 시작해서 가장 큰 자릿수가 되면 반복문을 종료한다.
		//뒤의 자릿값에 0이 들어가려면, 앞의 자리 숫자가 1이여야 한다.
		//뒤의 자릿값에 9가 들어가려면, 앞의 자리 숫자가 8이여야 한다.
		//뒤의 자릿값에 1~8까지가 들어가려면, 앞의 자리 숫자는 (뒤의 자릿값 - 1)과 (뒤의 자릿값 + 1)이다.
		//여기서 i는 자릿수를 의미하고, j는 뒤의 자릿값를 의미한다.
		//i - 1은 앞의 자릿수이다.
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) dp[i][j] = dp[i - 1][1];
				else if(j == 9) dp[i][j] = dp[i - 1][8];
				else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}
		
		//res를 마지막 자릿값의 0~9를 모두 더해준다.
		long res = 0;
		for(int i = 0; i < 10; i++) res += dp[N][i];
		
		System.out.println(res % mod);
	}
}