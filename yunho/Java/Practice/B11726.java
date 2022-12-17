package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726 { //2xn ≈∏¿œ∏µ

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tile = new int[N + 1];
		if(N == 1) {
			System.out.println(1);
			return;
		}
		tile[1] = 1; tile[2] = 2;
		for(int i = 3; i <= N; i++) tile[i] = (tile[i - 2] + tile[i - 1]) % 10007;
		System.out.println(tile[N]);
	}
}