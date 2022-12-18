package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 { //¸»ÀÌ µÇ°íÇÂ ¿ø¼þÀÌ
	private static int k, h, w;
	private static int[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine()); //¸» È½¼ö
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken()); //°¡·Î
		h = Integer.parseInt(st.nextToken()); //¼¼·Î
		
		map = new int[h][w];
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs());
	}

	public static int bfs() { //h row, w col
		boolean[][][] vis = new boolean[k + 1][h][w];
		int[] dRow = {1, 0, -1, 0}, dCol = {0, 1, 0, -1};
		int[][] holseM = {
				{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1 , -2}, {-2, 1}, {-2, -1}
		};
		
		Queue<Pair> Q = new LinkedList<>();
		Q.add(new Pair(0, 0, 0, 0));
		vis[0][0][0] = true;
		
		while(!Q.isEmpty()) {
			Pair cur = Q.remove();
			int curR = cur.getrow();
			int curC = cur.getcol();
			int curH = cur.getCount();
			int curX = cur.getX();
			
			if(curR == h - 1 && curC == w - 1) return curX;
			
			if(curH < k) {
				for(int i = 0; i < 8; i++) {
					int row = curR + holseM[i][0];
					int col = curC + holseM[i][1];		
					
					if(row < 0 || col < 0 || row >= h || col >= w) continue;
					if(map[row][col] == 1) continue;
					if(vis[curH + 1][row][col]) continue;
					
					Q.add(new Pair(row, col, curH + 1, curX + 1));
					vis[curH + 1][row][col] = true;
				}
			}
			for(int i = 0; i < 4; i++) {
				int row = curR + dRow[i];
				int col = curC + dCol[i];
					
				if(row < 0 || col < 0 || row >= h || col >= w) continue;
				if(map[row][col] == 1) continue;
				if(vis[curH][row][col]) continue;	
				
				Q.add(new Pair(row, col, curH, curX + 1));
				vis[curH][row][col] = true;
				}
		}
		return -1;
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