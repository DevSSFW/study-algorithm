package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2609 { //최대공약수와 최소공배수

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int tmp;
		
		if(a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		int r = a % b;
		if(r == 0) {
			System.out.println(b + "\n" + a);
			return;
		}
		
		int copy = b;
		while(copy % r != 0) {
			tmp = copy;
			copy = r;
			r = tmp % r;
		}
		
		System.out.println(r + "\n" + r * (a / r) * (b / r));
	}
}