package Baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class B_3052 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashSet<Integer> h = new HashSet<Integer>();
		
		for(int i = 0; i < 10; i++) {
			h.add(s.nextInt() % 42);
		}
		
		s.close();
		System.out.println(h.size());
	}
}
