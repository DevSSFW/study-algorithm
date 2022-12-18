package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 { //미로 탐색

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //row
		int m = Integer.parseInt(st.nextToken()); //col
		
		int[][] maze = new int[n][m]; //미로
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) maze[i][j] = Character.getNumericValue(s.charAt(j));
		}
		
		System.out.println(bfs(n, m, maze));
	}
	
	public static int bfs(int n, int m, int[][] maze) { //n = row, m = col
		int length = 0, size = 0, count = 0;
		boolean[][] vis = new boolean[n][m];
		
		int[] dRow = {1, 0, -1, 0};
		int[] dCol = {0, 1, 0, -1};
		
		Queue<Pair> Q = new LinkedList<>();
		Pair pair = new Pair(0, 0);
		Q.add(pair);
		vis[0][0] = true;
		length++;
		size = Q.size();
		
		Loop : while(!Q.isEmpty()) {
			Pair cur = Q.remove();
			count++;
			
			for(int i = 0; i < 4; i++) {
				int row = cur.getrow() + dRow[i];
				int col = cur.getcol() + dCol[i];
				
				if(row + 1 == n && col + 1 == m) {
					length++;
					break Loop;
				}
				if(row < 0 || col < 0 || row + 1 > n || col + 1 > m) continue;
				if(vis[row][col] || maze[row][col] != 1) continue;
				
				vis[row][col] = true;
				pair = new Pair(row, col);
				Q.add(pair);
			}
			
			if(count == size) {
				count = 0;
				size = Q.size();
				length++;
			}
		}
		
		return length;
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