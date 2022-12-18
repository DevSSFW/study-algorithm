package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B12865 { //평범한 배낭

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] stuff = new int[N][2];
		int[] price = new int[K + 1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(st.nextToken()); //무게
			int V = Integer.parseInt(st.nextToken()); //가치
			
			stuff[i][0] = W; stuff[i][1] = V;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = K; stuff[i][0] <= j; j--) {
				price[j] = Math.max(price[j - stuff[i][0]] + stuff[i][1] , price[j]);
			}
		}
		
		System.out.println(price[K]);
	}
}