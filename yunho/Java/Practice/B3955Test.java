package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3955Test { //Äµµð ºÐ¹è

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long k = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(c == 1) {
				if(k >= 1e9) System.out.println("IMPOSSIBLE");
				else System.out.println(k + 1);
				continue;
			}
			if(k == 1) {
				System.out.println(1);
				continue;
			}
			
			if(gcd(k, c) != 1) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			
			long t = gcdExtend(k, c);
			
			if(t > 1e9) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			else System.out.println(t);
		}
	}
	
	public static long gcd(long k, long c) {
		if(c == 0) return k;
		return gcd(c, k % c);
	}
	
	public static long gcdExtend(long k, long c) {
		long q, r = k % c, t3, t1 = 0, t2 = 1, tmpK = k;
		
		while(r > 0) {
			q = k / c;
			r = k % c;
			k = c;
			c = r;
			t3 = t1 - t2 * q;
			t1 = t2;
			t2 = t3;
		}
		while(t1 < 0) t1 += tmpK;
		return t1;
	}
}

