package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 { //N-Queen
	static int ans, N;
	static boolean[] c, p, m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		c = new boolean[N]; p = new boolean[N * 2]; m = new boolean[N * 2];
		search(0);
		System.out.println(ans);
	}
	static void search(int row) {
		if(row == N) {
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(c[i]) continue;
			if(p[row + i]) continue;
			if(m[row - i + N - 1]) continue;
			
			c[i] = true;
			p[row + i] = true;
			m[row - i + N - 1] = true;
			search(row + 1);
			c[i] = false;
			p[row + i] = false;
			m[row - i + N - 1] = false;	
		}
	}
}