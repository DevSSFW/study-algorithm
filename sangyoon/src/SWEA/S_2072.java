package SWEA;

import java.util.Scanner;

public class S_2072 {

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int A = sc.nextInt();
				if (A % 2 != 0) {
					sum += A;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
	
}
