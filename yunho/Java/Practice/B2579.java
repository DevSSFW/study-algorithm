package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 { //계단 오르기

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n + 2];
		for(int i = 0; i < n; i++) stair[i] = Integer.parseInt(br.readLine());
		
		int com1, com2;
		int[] ans = new int[n + 2];
		
		ans[0] = stair[0]; ans[1] = stair[0] + stair[1]; ans[2] = Math.max(stair[0], stair[1]) + stair[2];
		for(int i = 3; i < n; i++) {
			com1 = ans[i - 2];
			com2 = ans[i - 3] + stair[i - 1];
			
			ans[i] = Math.max(com1, com2) + stair[i];
		}
		
		System.out.println(ans[n - 1]);
	}
}