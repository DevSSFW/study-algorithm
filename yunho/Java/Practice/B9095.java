package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 { //1, 2, 3 ¥ı«œ±‚
	private static int[] count;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tt = 0; tt < t; tt++) {
			int n = Integer.parseInt(br.readLine());
			
			count = new int[n + 2];
			count[0] = 1;
			count[1] = 2;
			count[2] = 4;
			
			for(int i = 3; i < n; i++) count[i] = count[i - 1] + count[i - 2] + count[i - 3];
			
			System.out.println(count[n - 1]);
		}
	}
}