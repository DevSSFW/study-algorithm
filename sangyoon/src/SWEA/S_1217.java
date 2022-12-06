package SWEA;

import java.util.Scanner;

public class S_1217 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int t = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = calculate(N, M);
			System.out.println("#" + t + " " + result);
		}
	}
	
    public static int calculate(int N, int M) {
		if(M == 0) {
			return 1;
		}
		return N * calculate(N, M - 1);
	}
	
}
