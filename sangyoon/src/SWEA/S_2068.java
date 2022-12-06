package SWEA;

import java.util.Scanner;

public class S_2068 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int[] num = new int[10];
		int max = 0;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			for(int i = 0; i < 9; i++) {
				num[i] = sc.nextInt();
				if(num[i] > max) max = num[i];
			}
			System.out.println("#" + test_case + " " + max);
			max = 0;
		}
	}
	
}
