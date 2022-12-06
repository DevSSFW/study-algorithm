package SWEA;

import java.util.Scanner;

public class S_1926 {

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String sum = "";
		
		for(int i = 1; i <= N; i++) {
			sum = String.valueOf(i);
			
			if(sum.contains("3") || sum.contains("6") || sum.contains("9")) {
				sum = sum.replace("3", "-");
				sum = sum.replace("6", "-");
				sum = sum.replace("9", "-");
				
				sum = sum.replace("0", "");
				sum = sum.replace("1", "");
				sum = sum.replace("2", "");
				sum = sum.replace("4", "");
				sum = sum.replace("5", "");
				sum = sum.replace("7", "");
				sum = sum.replace("8", "");
			}
			
			System.out.print(sum + " ");
		}
	}
	
}
