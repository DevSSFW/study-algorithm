package Practice;

import java.util.Scanner;

public class B2475 { //°ËÁõ¼ö

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int n = sc.nextInt();
			n *= n;
			sum += n;
		}
		
		System.out.println(sum % 10);
	}
}
