package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9095_2 { //1, 2, 3 ¥ı«œ±‚

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int[] num = new int[11];
		num[1] = 1; num[2] = 2; num[3] = 4;
		for(int i = 4; i < 11; i++) num[i] = num[i - 3] + num[i - 2] + num[i - 1];
		for(int i = 0; i < T; i++) sb.append(num[Integer.parseInt(br.readLine())]).append("\n");
		System.out.println(sb);
	}
}