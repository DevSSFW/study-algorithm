package SWEA;

import java.util.Scanner;

public class S_1936 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A == 1) {
			if(B == 2) {
				System.out.println("B");
			} else if(B == 3) {
				System.out.println("A");
			}
		} else if (A == 2) {
			if(B == 1) {
				System.out.println("A");
			} else if(B == 3) {
				System.out.println("B");
			}
		} else if (A == 3) {
			if(B == 1) {
				System.out.println("B");
			} else if(B == 2) {
				System.out.println("A");
			}
		}
	}
	
}
