package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1012 { //유기농 배추
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		for(int l = 0; l < t; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken()); //col
			int n = Integer.parseInt(st.nextToken()); //row
			int num = Integer.parseInt(st.nextToken()); //배추 개수
			
			int[][] board = new int[n][m];
			boolean[][] vis = new boolean[n][m];
			Queue<int[]> Q = new LinkedList<>();
			for(int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				int nC = Integer.parseInt(st.nextToken());
				int nR = Integer.parseInt(st.nextToken());
				
				board[nR][nC] = 1;
			}
			
			int[] dRow = {1, 0, -1, 0};
			int[] dCol = {0, 1, 0, -1};
			int count = 0;
			Loop : for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(board[i][j] == 0 || vis[i][j]) continue;
					
					Q.add(new int[] {i, j});
					vis[i][j] = true;
									
					while(!Q.isEmpty()) {
						int[] cur = Q.remove();
			
						for(int k = 0; k < 4; k++) {
							int row = cur[0] + dRow[k];
							int col = cur[1] + dCol[k];
			
							if(row < 0 || col < 0 || row >= n || col >= m) continue;
							if(vis[row][col] || board[row][col] != 1) continue;
			
							Q.add(new int[] {row, col});
							vis[row][col] = true;
						}
					}
					count++;					
				}
			}
			
			System.out.println(count);
		}
	}
}