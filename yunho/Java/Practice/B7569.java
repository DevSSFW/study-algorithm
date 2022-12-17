package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 { //≈‰∏∂≈‰

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken()); //col
		int n = Integer.parseInt(st.nextToken()); //row
		int h = Integer.parseInt(st.nextToken()); //z
		
		int[][][] tomato = new int[h][n][m];
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) tomato[i][j][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> Q = new LinkedList<>();
		int[][][] dis = new int[h][n][m];
		
		for(int[][] a : dis) {
			for(int[] b : a) Arrays.fill(b, -1);
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(tomato[i][j][k] == 1) {
						dis[i][j][k] = 0;
						Q.add(new int[] {j, k, i});
					}
					else if(tomato[i][j][k] == 0) dis[i][j][k] = -2;
				}
			}
		}
		
		int[] dx = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			
			for(int i = 0; i < 6; i++) {
				int x = cur[0] + dx[i]; //row, n, j
				int y = cur[1] + dy[i]; //col, m, k
				int z = cur[2] + dz[i]; //h, i
				
				if(x < 0 || y < 0|| z < 0 || x >= n || y >= m || z >= h) continue;
				if(dis[z][x][y] > -2) continue;
				
				dis[z][x][y] = dis[cur[2]][cur[0]][cur[1]] + 1;
				Q.add(new int[] {x, y, z});
			}
		}
		
		int max = 0;
		Loop : for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(dis[i][j][k] == -2) {
						max = -1;
						break Loop;
					}
					
					max = Math.max(max, dis[i][j][k]);
				}
			}
		}
		
		System.out.println(max);
	}
}