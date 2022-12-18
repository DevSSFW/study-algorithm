package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179 { //บา!

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //row
		int m = Integer.parseInt(st.nextToken()); //col
		
		char[][] maze = new char[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) maze[i][j] = s.charAt(j);
		}
		
		int[][] jihun = new int[n][m];
		boolean[][] fire = new boolean[n][m];
		Queue<int[]> Q = new LinkedList<>();
		int[] J = new int[2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(maze[i][j] == '#') jihun[i][j] = -1;
				else if(maze[i][j] == '.') jihun[i][j] = 0;
				else if(maze[i][j] == 'J') {
					J = new int[]{i, j};
					jihun[i][j] = 1;
				}
				else if(maze[i][j] == 'F') {
					Q.add(new int[] {i, j});
					fire[i][j] = true;
				}
			}
		}
		Q.add(J);
		
		int[] dRow = {1, 0, -1, 0};
		int[] dCol = {0, 1, 0, -1};
		String ans = "";
		if(J[0] == 0 || J[0] == n - 1 || J[1] == 0 || J[1] == m - 1) ans = "1";
		else {
			Loop : while(!Q.isEmpty()) {
				int[] cur = Q.remove();
				for(int i = 0; i < 4; i++) {
					int row = cur[0] + dRow[i];
					int col = cur[1] + dCol[i];
					
					if(row < 0 || col < 0 || row >= n || col >= m) continue;
					if(fire[row][col] || jihun[row][col] != 0) continue;
					
					Q.add(new int[] {row, col});
					maze[row][col] = maze[cur[0]][cur[1]];
					if(maze[row][col] == 'J') {
						jihun[row][col] = jihun[cur[0]][cur[1]] + 1;
						if(row + 1 == n || col + 1 == m || row == 0 || col == 0) {
							ans = String.valueOf(jihun[row][col]);
							break Loop;
						}
					}
					fire[row][col] = true;
				}
			}
			if(Q.isEmpty()) ans = "IMPOSSIBLE";
		}
		System.out.println(ans);
	}
}