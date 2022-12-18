package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206Test { //벽 부수고 이동하기

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) maze[i][j] = s.charAt(j) - '0';
		}
		
		System.out.println(bfs(n, m, maze));
	}

	public static int bfs(int n, int m, int[][] maze) {
		int answer = 0;
		
		int[][] dis = new int[n][m];
		boolean[][] vis = new boolean[n][m], visB = new boolean[n][m];
		int[] dRow = {1,0,-1,0}, dCol = {0,1,0,-1};
		
		Queue<Pair> Q = new LinkedList<>();
		Pair pair = new Pair(0, 0, false);
				
		Q.add(pair);
		dis[0][0] = 1;
		vis[0][0] = true;
		
		Loop : while(!Q.isEmpty()) {
			Pair cur = Q.remove();
			int r = cur.getrow();
			int c = cur.getcol();
			boolean isBroke = cur.getIsTrue();
			
			for(int i = 0; i < 4; i++) {
				int row = r + dRow[i];
				int col = c + dCol[i];
					
				if(row < 0 || col < 0 || row >= n || col >= m) continue;
				if(maze[row][col] == 1 && !isBroke && !visB[row][col]) {
					Q.add(new Pair(row, col, true));
					visB[row][col] = true;
					dis[row][col] = dis[r][c] + 1;
					if(isAns(n, m, row, col)) break Loop;
					continue;
				}
				if(isBroke && (maze[row][col] == 1 || visB[row][col])) continue;
				if(visB[row][col] && maze[row][col] == 1) continue;
				if(vis[row][col]) continue;
				
				if(isBroke) visB[row][col] = true;
				else vis[row][col] = true;
				Q.add(new Pair(row, col, isBroke));
				dis[row][col] = dis[r][c] + 1;
				if(isAns(n, m, row, col)) break Loop;
			}			
		}
		
		if(dis[n - 1][m - 1] == 0) answer = -1;
		else answer = dis[n - 1][m - 1];
		
		return answer;
	}
	
	public static boolean isAns(int n, int m, int row, int col) {
		if(n - 1 == row && m - 1 == col) return true;
		else return false;
	}
	
	static class Pair {
		private int row, col, count, x; private boolean isTrue; private char c;
	 
	 	Pair(int row, int col) { this.row = row; this.col = col; }
	 
	 	Pair(int row, int col, boolean isTrue) { this.row = row; this.col = col; this.isTrue = isTrue; }
	 
	 	Pair(int row, int col, int count) { this.row = row; this.col = col; this.count = count; }
	 
	 	Pair(int row, int col, int count, int x) { this.row = row; this.col = col; this.count = count; this.x = x; }
	 
	 	Pair(int row, char c) { this.row = row; this.c = c; }
	 
	 	void set(int row, int col) { this.row = row; this.col = col; }
	 
	 	int getrow() { return row; }
	 
	 	int getcol() { return col; }
	 
	 	int getCount() { return count; }
	 
	 	int getX() { return x; }
	 
	 	boolean getIsTrue() { return isTrue; }
	 
	 	char getC() { return c; }
	 }
}
