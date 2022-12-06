package SWEA;

import java.util.Scanner;

public class S_2043 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		int K = sc.nextInt();
		int A = 0;
		
		for(int i = K; i <= P; i++) {
			A++;
		}
		System.out.print(A);
	}
	
}
