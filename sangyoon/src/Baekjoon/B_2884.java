package Baekjoon;

import java.util.Scanner;

public class B_2884 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int h = scanner.nextInt();
		int m = scanner.nextInt();
		
		if (m >= 45) {
			System.out.println(h + " " + (m - 45));
			
		} else if (m < 45) {
			if (h > 0) {
				System.out.println((h - 1) + " " + ((m - 45) + 60));
			} else if (h <= 0) {
				System.out.println(((h - 1) + 24) + " " + ((m - 45) + 60));
			}
		}
	}

}
