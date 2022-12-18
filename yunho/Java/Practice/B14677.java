package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B14677 { //∫¥æ‡«— ¿±»£
	private static int n;
	private static char[] M;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int size = n * 3;
		
		String s = br.readLine();
		M = new char[size];
		for(int i = 0; i < size; i++) {M[i] = s.charAt(i); System.out.print(M[i]);}
		System.out.println();
		System.out.println(bfs());	
	}

	public static int bfs() {
		int ans1 = 0, ans2 = 0, size = M.length - 1;
		int[] dx = {1, -1};
		char[] T = {'B', 'L', 'D'};
		boolean vis[] = new boolean[size + 1];
		
		Queue<Pair> Q = new LinkedList<>();
		
		Q.add(new Pair(0, M[0])); Q.add(new Pair(size, M[size]));
		vis[0] = true; vis[size] = true;
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 2; k++) {
					Pair cur = Q.remove();
					char curM = cur.getC();
					int index = cur.getrow();					
					
					char curM2 = ' ';
					int index2 = -1;
					if(!Q.isEmpty()) {
						curM2 = Q.element().getC();
						index2 = Q.element().getrow();
					}
					
					if(count == 2) count = 0;
					if(curM == curM2) {
						index2 += dx[count];
						Q.add(new Pair(index2, M[index2]));
					}
					if(curM == T[j]) {
						ans1++;
						index += dx[count];
						Q.add(new Pair(index, M[index]));
						count++;
						break;
					}
					else {
						Q.add(new Pair(index, M[index]));
						count++;
					}
				}
				
			}
		}
		
		return ans1;
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
