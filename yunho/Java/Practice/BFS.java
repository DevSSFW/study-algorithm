package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //row
		int m = Integer.parseInt(st.nextToken()); //col
		
		int[][] board = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		boolean[][] vis = new boolean[n][m];
		int[] dRow = {1, 0, -1, 0};
		int[] dCol = {0, 1, 0, -1};		
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {0, 0});
		vis[0][0] = true;

		int count = 1;
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();

			for(int i = 0; i < 4; i++) {
				int row = cur[0] + dRow[i];
				int col = cur[1] + dCol[i];

				if(row < 0 || col < 0 || row >= n || col >= m) continue;
				if(vis[row][col] || board[row][col] != 1) continue;

				Q.add(new int[] {row, col});
				vis[row][col] = true;
				count++;
			}
		}
		
		System.out.println(count);
	}
}