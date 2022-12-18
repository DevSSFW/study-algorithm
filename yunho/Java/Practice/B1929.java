package Practice;

import java.util.Scanner;

public class B1929 { //소수 구하기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt(); //m <= n <= 1,000,000
		
		for(int i = m; i <= n; i++) {
			boolean isZero = false;
			for(int j = 2; j < i; j++) {
				if(i > 3 && j * 2 > i) break;
				if(i % j == 0) {
					isZero = true;
					break;
				}
			}
			
			if(i == 1) isZero = true;
			if(!isZero) System.out.println(i);
		}
	}
}
