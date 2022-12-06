package SWEA;

import java.util.Scanner;

public class S_2025 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int A = 0;
		
		for(int i = 1; i <= T; i++) {
			A += i;
		}
		System.out.print(A);
	}
	
}
