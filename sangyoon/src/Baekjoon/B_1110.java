package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1110 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		int copy = n;
		
		do {
			n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
			count++;
		} while (copy != n);
		
		System.out.println(count);
		br.close();
	}
	
}
