package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 { //1로 만들기
	private static int[] count;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		count = new int[n + 3];
		One(n);
		
		System.out.println(count[n]);
	}
	
	public static void One(int n) {
		count[0] = 0; //0
		count[1] = 0; //1
		count[2] = 1; //2
		count[3] = 1; //3
		
		int three = 0, two = 0, one = 0;
		for(int i = 4; i <= n; i++) {
			three = n; two = n; one = n;
			if(i % 3 == 0) three = count[i / 3] + 1;
			if(i % 2 == 0) two = count[i / 2] + 1;
			one = count[i - 1] + 1;
			
			count[i] = Math.min(Math.min(three, two), one);
		}
	}
}
