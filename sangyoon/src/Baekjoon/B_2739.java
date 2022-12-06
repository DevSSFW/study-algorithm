package Baekjoon;

import java.util.Scanner;

public class B_2739 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(n + " * " + i + " = " + (n * i));
		}
	}

}
