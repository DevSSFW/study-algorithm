package Baekjoon;

import java.util.Scanner;

public class B_10950 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < n; i++ ) {
			a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
		}
		
		for (int j = 0; j < n; j++) {
			System.out.println(a[j] + b[j]);
		}
	}

}
