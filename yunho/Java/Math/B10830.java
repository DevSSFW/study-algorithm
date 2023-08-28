package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10830 { //Çà·Ä Á¦°ö
	static int N;
	static long B;
	static int[][] mat;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		mat = new int[N][N];
		int[][] temp_mat = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				mat[i][j] = n;
				temp_mat[i][j] = n;
			}
		}
		mat = solve(B, temp_mat);
		
		print_mat(mat);
	}
	
	static int[][] solve(long B, int[][] temp_mat) {
		if(B == 1) return temp_mat;
		
		temp_mat = solve(B / 2, temp_mat);
		temp_mat = mul_mat(temp_mat, temp_mat);
		
		if(B % 2 == 1) temp_mat = mul_mat(temp_mat, mat);
		
		return temp_mat;
	}
	
	static int[][] mul_mat(int[][] o1, int[][] o2) {
		int[][] res = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) res[i][j] += o1[i][k] * o2[k][j] % 1000;
			}
		}
		
		return res;
	}
	
	static void print_mat(int[][] m) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) sb.append(m[i][j] % 1000).append(' ');
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}