package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15829 { //Hashing

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mod = 1234567891;
		int l = Integer.parseInt(br.readLine());
		int[] arr = new int[l];
		
		String s = br.readLine();
		for(int i = 0; i < l; i++) arr[i] = s.charAt(i) - 'a' + 1;
		
		int ans = arr[0];
		long r = 1;
		for(int i = 1; i < l; i++) {
			long num = arr[i];
			
			r *= 31;
			r %= mod;
			
			num = num * r;
			ans = (int)((ans + num) % mod);
		}
		
		System.out.println(ans);
	}
}