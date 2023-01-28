package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629 { //°ö¼À
	static int A, B, C;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(Solve(B) % C);
	}
	
	static long Solve(int n) {
		if(n == 1) return A % C;
		
		long num = Solve(n / 2);
		if(n % 2 == 1) return (num * num % C) * A % C;
		else return num * num % C;
	}
}