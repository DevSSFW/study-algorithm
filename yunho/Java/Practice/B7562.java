package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 { //나이트의 이동
	private static boolean[][] vis;
	private static int[] start, end;
	private static int size;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		start = new int[2];
		end = new int[2];
		
		for(int i = 0; i < T; i++) {
			size = Integer.parseInt(br.readLine());
			vis = new boolean[size][size];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			int ans = bfs();
			
			System.out.println(ans);
		}
	}
	
	public static int bfs() {
		int dx[][] = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(start[0], start[1], 0));
		vis[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			Pair cur = q.remove();
			int row = cur.getrow();
			int col = cur.getcol();
			int count = cur.getCount();
			
			if(row == end[0] && col == end[1]) return count;
			for(int i = 0; i < 8; i++) {
				int r = row + dx[i][0];
				int c = col + dx[i][1];
				
				if(r >= size || c >= size || r < 0 || c < 0 || vis[r][c]) continue;
				
				vis[r][c] = true;
				q.add(new Pair(r, c, count + 1));
			}
		}
		
		return 0;
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
