package Baekjoon;

import java.util.Scanner;

public class B_8393 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = 0;
		
		for (int i = 1; i <= n; i++ ) {
			m += i;
		}
		
		System.out.println(m);
	}

}
