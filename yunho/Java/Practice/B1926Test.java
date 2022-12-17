package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1926Test { //±×¸²
	private static int n, m, size;
	private static int[] dRow = {1, 0, -1, 0};
	private static int[] dCol = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] paint = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) paint[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0, max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(paint[i][j] == 0) continue;
				
				size = 1;
				paint[i][j] = 0;
				dfs(i, j, paint);
				count++;
				max = Math.max(size, max);
			}
		}
		
		System.out.println(count + "\n" + max);
	}

	public static void dfs(int row, int col, int[][] paint) {
		for(int i = 0; i < 4; i++) {
			int cRow = row + dRow[i];
			int cCol = col + dCol[i];
			
			if(cRow < 0 || cCol < 0 || cRow >= n || cCol >= m) continue;
			if(paint[cRow][cCol] != 1) continue;
			
			paint[cRow][cCol] = 0;
			size++;
			dfs(cRow, cCol, paint);
		}
	}
}