package SWEA;

import java.util.Scanner;

public class S_1204 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
			int[] score = new int[101];
			
			for(int i = 0; i < 1000; i++) {
				score[sc.nextInt()]++;
			}
			
			int max = 0;
			int index = 0;
			
			for(int i = 0; i < score.length; i++) {
				if(score[i] >= max) {
					max = score[i];
					index = i;
				}
			}
			System.out.println("#" + num + " " + index);
		}
	}
	
}
