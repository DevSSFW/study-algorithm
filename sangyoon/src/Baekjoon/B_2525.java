package Baekjoon;

import java.util.Scanner;

public class B_2525 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int h = scanner.nextInt();
		int m = scanner.nextInt();
		int t = scanner.nextInt();
		
		int a = h * 60 + m + t;
		h = a / 60;
		m = a % 60;
		
		if ( h >= 24)
			h -= 24;
		
		System.out.println(h + " " + m);
	}

}
