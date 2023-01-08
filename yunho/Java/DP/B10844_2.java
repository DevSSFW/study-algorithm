package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10844_2 { //���� ��� ��, ���� �ڸ������� ����(Bottom_Up)
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), mod = 1000000000;
		
		int[][] dp = new int[N + 1][10];
		
		//���� ū �ڸ���, �� ���� �տ� �ִ� ����
		for(int i = 1; i < 10; i++) dp[1][i] = 1;

		//���� �ڸ������� �����ؼ� ���� ū �ڸ����� �Ǹ� �ݺ����� �����Ѵ�.
		//���� �ڸ����� 0�� ������, ���� �ڸ� ���ڰ� 1�̿��� �Ѵ�.
		//���� �ڸ����� 9�� ������, ���� �ڸ� ���ڰ� 8�̿��� �Ѵ�.
		//���� �ڸ����� 1~8������ ������, ���� �ڸ� ���ڴ� (���� �ڸ��� - 1)�� (���� �ڸ��� + 1)�̴�.
		//���⼭ i�� �ڸ����� �ǹ��ϰ�, j�� ���� �ڸ����� �ǹ��Ѵ�.
		//i - 1�� ���� �ڸ����̴�.
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) dp[i][j] = dp[i - 1][1];
				else if(j == 9) dp[i][j] = dp[i - 1][8];
				else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}
		
		//res�� ������ �ڸ����� 0~9�� ��� �����ش�.
		long res = 0;
		for(int i = 0; i < 10; i++) res += dp[N][i];
		
		System.out.println(res % mod);
	}
}