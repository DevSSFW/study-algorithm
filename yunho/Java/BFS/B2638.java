package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2638 { //ДЎБо
	static int N, M;
	static int[][] map;
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
	static ArrayList<int[]> melt;
	static boolean[][] isSpace;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		melt = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] vis = new boolean[N][M];
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		PQ.add(new int[] {0, 0, 0});
		vis[0][0] = true;
		
		int max = 0, prev = -1;
		while(!PQ.isEmpty()) {
			int[] cur = PQ.remove();
			
			if(prev != cur[2]) {
				max = cur[2];
				prev = max;
				
				for(int[] c : melt) map[c[0]][c[1]] = 0;
				isSpace = new boolean[N][M];
				space();
			}
			
			for(int i = 0; i < 4; i++) {
				int col = cur[0] + dx[i];
				int row = cur[1] + dy[i];
				
				if(col < 0 || row < 0 || col >= N || row >= M || vis[col][row]) continue;
				if(map[col][row] == 0) {
					PQ.add(new int[] {col, row, cur[2]});
					vis[col][row] = true;
				}
				else if(check(col, row) > 1) {
						PQ.add(new int[] {col, row, cur[2] + 1});
						vis[col][row] = true;
						melt.add(new int[] {col, row});
				}
			}
		}
		
		System.out.println(max);
	}
	
	static int check(int col, int row) {
		int res = 0;
		
		for(int i = 0; i < 4; i++) {
			int c = col + dx[i];
			int r = row + dy[i];
			
			if(col < 0 || row < 0 || col >= N || row >= M) continue;
			if(isSpace[c][r]) res++;
		}
		
		return res;
	}
	
	static void space() {
		Queue<int[]> Q = new LinkedList<>();
		boolean[][] vis = new boolean[N][M];
		
		Q.add(new int[] {0, 0});
		vis[0][0] = true;
		isSpace[0][0] = true;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			
			isSpace[cur[0]][cur[1]] = true;
			
			for(int i = 0; i < 4; i++) {
				int col = cur[0] + dx[i];
				int row = cur[1] + dy[i];
				
				if(col < 0 || row < 0 || col >= N || row >= M || vis[col][row]) continue;
				if(map[col][row] == 0) {
					Q.add(new int[] {col, row});
					vis[col][row] = true;
				}
			}
		}
	}
}