package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1926 { //�׸�

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //row
		int m = Integer.parseInt(st.nextToken()); //col
		int[][] paint = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) paint[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] dRow = {1, 0, -1, 0};
		int[] dCol = {0, 1, 0, -1};
		int size = 0, count = 0, max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(paint[i][j] == 0) continue;
				
				Pair pair = new Pair(0, 0);
				pair.set(i, j);
				paint[i][j] = 0;
				size++;
				
				Queue<Pair> Q = new LinkedList<>();
				Q.add(pair);
				while(!Q.isEmpty()) {
					Pair cur = Q.remove();
				
					for(int k = 0; k < 4; k++) { //����� �����¿� �湮
						int row = cur.getrow() + dRow[k];
						int col = cur.getcol() + dCol[k];
					
						if(row < 0 || col < 0 || row + 1 > n || col + 1 > m) continue;
						if(paint[row][col] != 1) continue;
					
						paint[row][col] = 0; //���� �׸��� Ȯ���ϱ� ���� 0���� ����, �湮�� ���
						Pair newpair = new Pair(row, col); //�࿭�� newpair�� ����
						Q.add(newpair); //Queue�� �湮�� ��带 �߰�
						size++;
					}
				}
				if(size > max) max = size;
				size = 0;
				count++;
			}
		}
		
		System.out.println(count + "\n" + max);
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