package SWEA;

import java.util.Scanner;

public class S_1206 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] building = new int[N];
			for (int i = 0; i < N; i++) {
				building[i] = sc.nextInt();
			}
			
			int count = 0;
			for (int i = 2; i < N - 2; i++) {
				int max = Math.max(building[i - 2], Math.max(building[i -1], Math.max(building[i + 1], building[i + 2])));
				if (building[i] - max > 0) {
					count += building[i] - max;
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
	}
	
}
