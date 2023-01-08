package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10844_1 { //���� ��� ��, ���� ū �ڸ������� ����(Top-Down)
	static int mod = 1000000000;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		
		//���� ���� �ڸ���, �� ���� �ڸ����� ��
		for(int i = 0; i < 10; i++) dp[1][i] = 1;
		
		//���� ���� �ڸ��� 1~9�� ������ ���Ѵ�.
		for(int i = 1; i < 10; i++) solve(N, i);
		
		long res = 0;
		for(int i = 1; i < 10; i++) res += dp[N][i];
		System.out.println(res % mod);
	}

	//���� ū �ڸ������� �����ؼ� ���� �ڸ����� �Ǹ� ��Ͱ� ������.
	//digit : �ڸ���, num : �ڸ���
	//�ڸ����� ���� �ڸ� ���ڰ� �Ǹ� ��͸� �����Ѵ�. ��, digit�� 1�� �Ǹ� �����Ѵ�.
	//dp[digit][num]�� ������ �ʾҴٸ�, ��͸� �����Ѵ�.
	//�ڸ����� 0�̸� ���� �ڸ����� 1�̴�.
	//�ڸ����� 9�� ���� �ڸ����� 8�̴�.
	//�ڸ����� 1~8�̸� ���� �ڸ����� (�ڸ��� - 1)�� (�ڸ��� + 1)�̴�.
	//��ȯ���� ���� �ڸ��������� ������ ���ڰ� �� �� �ִ� ����(dp[digit][num])�� ��ȯ�Ѵ�.
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