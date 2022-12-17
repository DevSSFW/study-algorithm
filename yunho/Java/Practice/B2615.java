package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2615 { //¿À¸ñ
	static int[][] map = new int[19][19];
	static int[] dx = {1, -1}, dy = {1, -1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(check(i, j, map[i][j])) return;
			}
		}
		
		System.out.println(0);
	}
	
	static boolean check(int row, int col, int num) {
		if(num == 0) return false;
		
		Roop : for(int i = 0; i < 2; i++) {
			for(int j = 1; j < 5; j++) {
				int r = row + dx[i] * j;
				
				if(r < 0 || r >= 19 || map[row][col] != map[r][col]) continue Roop;
			}
			
			int r = row + dx[i] * 5;
			
			if(r < 0 || r >= 19 || map[row][col] != map[r][col]) {
				r = row - dx[i];
				if(r < 0 || r >= 19 || map[row][col] != map[r][col]) {
					System.out.println(map[row][col]);
					row++; col++;
					System.out.println(row + " " + col);
					return true;
				}
			}
		}
		
		Roop : for(int i = 0; i < 2; i++) {
			for(int j = 1; j < 5; j++) {
				int c = col + dx[i] * j;
				
				if(c < 0 || c >= 19 || map[row][col] != map[row][c]) continue Roop;
			}
			
			int c = col + dx[i] * 5;
			
			if(c < 0 || c >= 19 || map[row][col] != map[row][c]) {
				c = col - dx[i];
				if(c < 0 || c >= 19 || map[row][col] != map[row][c]) {
					System.out.println(map[row][col]);
					row++; col++;
					System.out.println(row + " " + col);
					return true;
				}
			}
		}
		
		for(int i = 0; i < 2; i++) {
			Roop : for(int j = 0; j < 2; j++) {
				for(int k = 1; k < 5; k++) {
					int r = row + dx[i] * k, c = col + dy[j] * k;
					
					if(r < 0 || c < 0 || r >= 19 || c >= 19 || map[row][col] != map[r][c]) continue Roop;
				}
				
				int r = row + dx[i] * 5, c = col + dy[j] * 5;
				
				if(r < 0 || c < 0 || r >= 19 || c >= 19 || map[row][col] != map[r][c]) {
					r = row - dx[i]; c = col - dy[j];
					if(r < 0 || c < 0 || r >= 19 || c >= 19 || map[row][col] != map[r][c]) {
						if(dy[j] < 0) {
							System.out.println(map[row][col]);
							row = row + dx[i] * 4; col = col + dy[j] * 4;
							row++; col++;
							System.out.println(row + " " + col);
						}
						
						else {
							System.out.println(map[row][col]);
							row++; col++;
							System.out.println(row + " " + col);
						}
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
}