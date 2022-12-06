package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S_2063 {

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList a = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int score = sc.nextInt();
			a.add(score);
		}
		
		Collections.sort(a);
		int num = Integer.parseInt(a.get(N / 2).toString());
		
		System.out.println(num);
	}
	
}
