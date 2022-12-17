package Practice;

import java.util.Scanner;

public class B2097 { //조약돌

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE; //작은 둘레
		
		if(n < 4) {
			System.out.println(4);
			return;
		}
		
		int i;
		for(i = 1; i * i <= n; i++) {
			int num; //비교할 숫자
			if(n % i == 0) num = (n / i + i - 2) * 2; //n
			else num = (n / i + i - 1) * 2; //n보다 크고, 제곱수보다 작은 수들
			
			min = Math.min(num, min);
		}
		min = Math.min(min, (i - 1) * 4); //n보다 큰 제곱수와 둘레 비교
		
		System.out.println(min);
	}
}