package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940 { //쉬운 최단거리
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int N, M;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dis = new int[N][M];
		boolean[][] vis = new boolean[N][M];
		Queue<int[]> Q = new LinkedList<>();
		
		for(int[] arr : dis) Arrays.fill(arr, -1);

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			
				if(map[i][j] == 0) dis[i][j] = 0;
				else if(map[i][j] == 2) {
					Q.add(new int[] {i, j});
					dis[i][j] = 0;
				}
			}
		}
		
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			int row = cur[0], col = cur[1];
			
			if(vis[row][col]) continue;
			vis[row][col] = true;
			
			for(int i = 0; i < 4; i++) {
				int r = row + dx[i];
				int c = col + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= M || vis[r][c] || map[r][c] == 0) continue;
				
				dis[r][c] = dis[row][col] + 1;
				Q.add(new int[] {r, c});
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) sb.append(dis[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}