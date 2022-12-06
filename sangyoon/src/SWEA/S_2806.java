package SWEA;

import java.util.Scanner;

public class S_2806 {
	static int board[];
	static int answer;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int num;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			num = sc.nextInt();
			board = new int[num];
			answer = 0;
			countNQueenCase(num, 0);
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static void countNQueenCase(int n, int curr) {
		boolean isPossible;
		if(curr == n) {
			answer++;
			return;
		}
		for(int i = 0; i < n; i++) {
			isPossible = true;
			for(int j = 0; j < curr; j++) {
				if(board[j] == i || i == board[j] + (curr - j) || i == board[j] - (curr - j)) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				board[curr] = i;
				countNQueenCase(n, curr + 1);
			}
		}
	}
	
}
