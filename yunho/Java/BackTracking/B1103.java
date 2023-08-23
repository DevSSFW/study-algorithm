package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1103 { //∞‘¿”
	static int N, M, hole;
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
	static int[][] map, dist;
	static boolean[][] vis;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		vis = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < M; j++) map[i][j] = str.charAt(j) - '0';
		}
		vis[0][0] = true;
		hole = 'H' - '0';
		
		dist[0][0] = search(0, 0);
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(dist[i][j] >= 100000) {
					System.out.println(-1);
					return;
				}
				
				max = Math.max(max, dist[i][j]);
			}
		}
		
		System.out.println(max);
	}
	
	static int search(int col, int row) {
		for(int i = 0; i < 4; i++) {
			int c = col + dx[i] * map[col][row];
			int r = row + dy[i] * map[col][row];
			
			if(c < 0 || r < 0 || c >= N || r >= M || map[c][r] == hole) continue;
			if(vis[c][r] || dist[c][r] >= 100000) return 100000;
			
			vis[c][r] = true;
			if(dist[c][r] > 0) dist[col][row] = Math.max(dist[col][row], dist[c][r] + 1);
			else dist[col][row] = Math.max(dist[col][row], search(c, r));
			vis[c][r] = false;
		}
		
		return dist[col][row] + 1;
	}
}