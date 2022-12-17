package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206_2 { //벽 부수고 이동하기
	static int N, M;
	static int[][] map;
	static boolean[][] vis, vis_crash; //vis : 한번도 부수지 않은 상태로 방문, vis_crash : 한번 부순 상태로 방문
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		vis = new boolean[N][M]; vis_crash = new boolean[N][M];
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) map[i][j] = s.charAt(j) - '0';
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Pair> Q = new LinkedList<>();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		Q.add(new Pair(0, 0, 1, false));
		vis[0][0] = true;
		
		while(!Q.isEmpty()) {
			Pair cur = Q.remove();
			int row = cur.row, col = cur.col, count = cur.count;
			boolean crash = cur.crash;
			
			if(row == N - 1 && col == M - 1) return count;
			
			for(int i = 0; i < 4; i++) {
				int r = row + dx[i];
				int c = col + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= M || vis[r][c]) continue; //한번도 부수지 않은 상태에서 방문했으면 또 다시 방문할 필요가 없다.
				if(map[r][c] == 1 && crash) continue; //벽을 한번 부신 상태에서 벽을 만났을 때
				else if(crash) { //벽을 한번 부순 상태에서 이동할 수 있는 곳으로 갔을 때
					if(vis_crash[r][c]) continue; //한번 부순 상태에서 이미 방문 했으면 방문할 필요가 없다.
					
					Q.add(new Pair(r, c, count + 1, true));
					vis_crash[r][c] = true; //한번 부순 상태에서 방문했음을 남긴다.
					continue;
				}
				else if(map[r][c] == 1) { //벽을 한번도 부수지 않은 상태에서 벽을 만났을 때
					Q.add(new Pair(r, c, count + 1, true));
					vis[r][c] = true; //한번도 부수지 않은 상태에서 방문했음을 남긴다.
					continue;
				}
				else { //벽을 한번도 부수지 않은 상태에서 이동할 수 있는 곳으로 갔을 때
					Q.add(new Pair(r, c, count + 1, false));
					vis[r][c] = true; //한번도 부수지 않은 상태에서 방문했음을 남긴다.
				}
			}
		}
		
		return -1; //목적지까지 이동하지 못했을 경우
	}
	
	static class Pair {
		int row, col, count;
		boolean crash;
		
		Pair(int row, int col, int count, boolean crash) {
			this.row = row;
			this.col = col;
			this.count = count;
			this.crash = crash;
		}
	}
}