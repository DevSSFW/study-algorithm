package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9461 { //파도반 수열

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] P = new long[101];
		P[1] = 1; P[2] = 1; P[3] = 1; P[4] = 2;
		for(int i = 5; i <= 100; i++) P[i] = P[i - 1] + P[i - 5];
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) sb.append(P[Integer.parseInt(br.readLine())]).append("\n");
		
		System.out.println(sb);
	}
}