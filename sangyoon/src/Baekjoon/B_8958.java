package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_8958 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		String arr[] = new String[test_case];
		
		for(int i = 0; i < test_case; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i = 0; i < test_case; i++) {
			int sum = 0;
			int cnt = 0;
			
			for(int j = 0; j < arr[i].length(); j++) {
				if(arr[i].charAt(j) == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			
			System.out.println(sum);
		}
		
	}

}
