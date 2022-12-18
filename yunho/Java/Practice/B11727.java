package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11727 { //2xn ≈∏¿œ∏µ 2

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tiles = new int[1001];
		tiles[1] = 1; tiles[2] = 3;
		for(int i = 3; i <= 1000; i++) tiles[i] = (tiles[i - 2] * 2 + tiles[i - 1]) % 10007;
		
		System.out.println(tiles[N]);
	}
}