package SWEA;

import java.util.Scanner;

public class S_1986 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
			int result = 0;
			for(int i = 1; i <= num; i++) {
				if(i % 2 == 0) {
					result -= i;
				} else {
					result += i;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
	
}
