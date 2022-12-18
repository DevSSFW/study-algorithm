package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1676 { //팩토리얼 0의 개수

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[501];
		for(int i = 5; i <= N; i++) {
			num[i] = num[i - 1];
			if(i % 5 == 0) {
				int n = i;
				while(n % 5 == 0) {
					n /= 5;
					num[i]++;
				}
			}
		}
		System.out.println(num[N]);
	}
}