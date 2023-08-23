package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2580 { //스도쿠
	static int[][] map = new int[9][9];
	static boolean[][] vis = new boolean[9][9];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
	
		solve(0, 0);
	}
	
	static void solve(int row, int col) {
		if(col == 9) {
			solve(row + 1, 0);
			return;
		}
		
		if(row == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) sb.append(map[i][j]).append(" ");
				sb.append("\n");
			}
			
			System.out.println(sb);
			System.exit(0);
		}
		
		if(map[row][col] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(check(row, col, i)) {
					map[row][col] = i;
					solve(row, col + 1);
				}
			}
			
			map[row][col] = 0;
			return;
		}
		
		solve(row, col + 1);
	}
	
	static boolean check(int row, int col, int num) {
		//가로
		for(int i = 0; i < 9; i++) {
			if(map[row][i] == num) return false;
		}
		
		//세로
		for(int i = 0; i < 9; i++) {
			if(map[i][col] == num) return false;
		}
		
		//박스
		int temp_row = row / 3 * 3, temp_col = col / 3 * 3;
		for(int i = temp_row; i < temp_row + 3; i++) {
			for(int j = temp_col; j < temp_col + 3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		
		return true;
	}
}