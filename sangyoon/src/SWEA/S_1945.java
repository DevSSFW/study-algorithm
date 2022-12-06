package SWEA;

import java.util.Scanner;

public class S_1945 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			
			int temp = N;
			while(temp % 2 == 0) {
				a++;
				temp /= 2;
			}
			
			temp = N;
			while(temp % 3 == 0) {
				b++;
				temp /= 3;
			}
			
			temp = N;
			while(temp % 5 == 0) {
				c++;
				temp /= 5;
			}
			
			temp = N;
			while(temp % 7 == 0) {
				d++;
				temp /= 7;
			}
			
			temp = N;
			while(temp % 11 == 0) {
				e++;
				temp /= 11;
			}
			
			System.out.println("#" + test_case + " " + a + " " + b + " " + c + " " + d + " " + e);
		}
    }
	
}
