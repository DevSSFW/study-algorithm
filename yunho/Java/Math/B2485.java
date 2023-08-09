package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2485 { //°¡·Î¼ö
	static int N;
	static int[] trees;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		trees = new int[N];
		for(int i = 0; i < N; i++) trees[i] = Integer.parseInt(br.readLine());
		
		int dis = trees[1] - trees[0];
		for(int i = 2; i < N; i++) dis = find_gcd(trees[i] - trees[0], dis);
		System.out.println((trees[N - 1] - trees[0]) / dis + 1 - N);
	}
	
	static int find_gcd(int a, int b) {
		while(a % b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return b;
	}
}