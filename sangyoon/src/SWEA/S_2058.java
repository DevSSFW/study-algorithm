package SWEA;

import java.util.Scanner;

public class S_2058 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = N / 1000;
		int b = (N % 1000) / 100;
		int c = (N % 100) / 10;
		int d = N % 10;
		
		System.out.print(a + b + c + d);
	}
	
}
