package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class S_1208 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt();
			int[] arr = new int[100];
			
			for(int i = 0; i < arr.length; i++)	arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			for(int i = 0; i < dump ; i++) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			
			System.out.println("#" + test_case + " " + (arr[99] - arr[0]));
		}
	}
	
}
