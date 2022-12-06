package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S_1933 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		ArrayList<Integer> num = new ArrayList<>();

		for(int i = 1; i <= T; i++) {
			if(T % i == 0) num.add(i);
		}
		
		Collections.sort(num);
		
		for(Integer i : num) {
			System.out.print(i + " ");
		}
	}
	
}
