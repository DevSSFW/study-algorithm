package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B21608 { //상어 초등학교

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		HashMap<Integer, int[]> student = new HashMap<>();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[] favor = new int[4];
		for(int j = 0; j < 4; j++) favor[j] = Integer.parseInt(st.nextToken());
		student.put(num, favor);
		map[1][1] = num;
		
		for(int i = 1; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			favor = new int[4];
			for(int j = 0; j < 4; j++) favor[j] = Integer.parseInt(st.nextToken());
			student.put(num, favor);
			
			int row = -1, col = -1, count = 0, empty = 0, tempC = 0, tempE = 0;
			
			for(int j = N - 1; j >= 0; j--) {
				for(int k = N - 1; k >= 0; k--) {
					if(map[j][k] != 0) continue;
					
					for(int l = 0; l < 4; l++) {
						int r = j + dx[l], c = k + dy[l];
						
						if(r < 0 || c < 0 || r >= N || c >= N) continue;
						
						if(map[r][c] == 0) tempE++;
						else {
							for(int m = 0; m < 4; m++) {
								if(favor[m] == map[r][c]) {
									tempC++;
									break;
								}
							}
						}
					}
					
					if(tempC > count) {
						row = j; col = k;
						count = tempC;
						empty = tempE;
					}
					else if(tempC == count) {
						if(tempE >= empty) {
							row = j; col = k;
							empty = tempE;
						}
					}
					
					tempC = 0; tempE = 0;
				}
			}
			
			map[row][col] = num;
			count = 0; empty = 0;
		}
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int[] stu = student.get(map[i][j]);
				int temp = 0;
				
				for(int k = 0; k < 4; k++) {
					int r = i + dx[k], c = j + dy[k];
					
					if(r < 0 || c < 0 || r >= N || c >= N) continue;
					
					for(int l = 0; l < 4; l++) {
						if(stu[l] == map[r][c]) {
							temp++;
							break;
						}
					}
				}
				
				switch(temp) {
				case 1: 
					res += 1;
					break;
				case 2:
					res += 10;
					break;
				case 3:
					res += 100;
					break;
				case 4:
					res += 1000;
					break;
				}
			}
		}
		
		System.out.println(res);
	}
}