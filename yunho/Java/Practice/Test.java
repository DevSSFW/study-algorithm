package Practice;

import java.util.Arrays;

public class Test {
	static int[] a;
	
	static void te(int[] t) {
		for(int i = 0; i < 10; i++) t[i] = 0;
	}
	
	static void te(int t) {
		t = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		a = new int[10];
		
		Arrays.fill(a, 10);
		Arrays.fill(arr, 100);
		
		te(a);
		te(arr);
		
		int sumA = 0, sumArr = 0; 
		for(int i = 0; i < 10; i++) {
			sumA += a[i];
			sumArr += arr[i];
		}
		System.out.println("sumA : " + sumA + " sumArr : " + sumArr);
		
		int n = 100;
		te(n);
		System.out.println("n : " + n);
	}
}