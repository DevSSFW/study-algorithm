package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 { //≈‰∏∂≈‰

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken()); //col
		int n = Integer.parseInt(st.nextToken()); //row
		
		int[][] tomato = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) tomato[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Pair> array = new ArrayList<>();
		int[][] answer = new int[n][m];
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(tomato[i][j] >= 1) {
					count++;
					Pair p = new Pair(i, j);
					array.add(p);
					answer[i][j] = 1;
				}
				else if(tomato[i][j] == -1) {
					answer[i][j] = -1;
				}
			}
		}
		
		int dRow[] = {1, 0, -1, 0};
		int dCol[] = {0, 1, 0, -1};
		
		Queue<Pair> Q = new LinkedList<>();
		
		for(int i = 0; i < count; i++) {
			Q.add(array.get(i));
		}
		
		while(!Q.isEmpty()) {
			Pair cur = Q.remove();
			int r = cur.getrow(), c = cur.getcol();
			
			for(int i = 0; i < 4; i++) {
				int row = r + dRow[i];
				int col = c + dCol[i];
			
				if(row < 0 || col < 0 || row >= n || col >= m || tomato[row][col] != 0) continue;
				if(answer[row][col] > 0) continue;
				
				answer[row][col] = answer[r][c] + 1;
				Pair pair = new Pair(row, col);
				Q.add(pair);
			}
		}
		
		int max = 0;
		Loop : for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(answer[i][j] == 0) {
					max = -1;
					break Loop;
				}
				
				max = Math.max(max, answer[i][j] - 1);
			}
		}
		
		System.out.println(max);
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