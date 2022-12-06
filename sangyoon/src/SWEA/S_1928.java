package SWEA;

import java.util.Base64;
import java.util.Scanner;

public class S_1928 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.nextLine();
			String result = new String(Base64.getDecoder().decode(str));
			System.out.println("#" + test_case + " " + result);
		}
	}
	
}
