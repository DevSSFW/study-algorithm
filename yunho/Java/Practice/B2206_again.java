package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B2206_again { //벽 부수고 이동하기
	static int N, M;
	static int[][] map, wall_dis;
	static boolean[][] vis;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
	
		N = Integer.parseInt(st[0]); M = Integer.parseInt(st[1]);
		map = new int[N][M]; vis = new boolean[N][M]; wall_dis = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) map[i][j] = s.charAt(j) - '0';
		}
		
		for(int[] a : wall_dis) { 
			Arrays.fill(a, Integer.MAX_VALUE); 
		}
		
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {0, 0, 1});
		vis[0][0] = true; wall_dis[0][0] = 0;
		
		int min = Integer.MAX_VALUE;
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			int row = cur[0], col = cur[1], dis = cur[2];
			
			if(row == N - 1 && col == M - 1) {
				min = Math.min(min, dis);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int r = cur[0] + dx[i], c = cur[1] + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= M || vis[r][c]) continue;

				vis[r][c] = true;
				if(map[r][c] == 1) min = Math.min(wall(r, c, dis + 1), min);
				else Q.add(new int[] {r, c, dis + 1});
			}
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	static int wall(int row, int col, int dis) {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {row, col, dis});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			
			if(cur[0] == N - 1 && cur[1] == M - 1) return cur[2];
			
			for(int i = 0; i < 4; i++) {
				int r = cur[0] + dx[i], c = cur[1] + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= M || vis[r][c] || wall_dis[r][c] <= cur[2] || map[r][c] == 1) continue;
				
				Q.add(new int[] {r, c, cur[2] + 1});
				wall_dis[r][c] = cur[2];
			}
		}
		
		return Integer.MAX_VALUE;
	}
}