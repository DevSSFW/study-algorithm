package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234 { //인구 이동
	static int N, L, R;
	static int[][] map;
	static boolean[][] vis;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		while(solve()) res++;
		
		System.out.println(res);
	}
	
	static boolean solve() {
		boolean res = false;
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
		
		Queue<int[]> Q = new LinkedList<>();
		vis = new boolean[N][N];
		
		for(int k = 0; k < N; k++) {
			for(int j = 0; j < N; j++) {
				if(vis[k][j]) continue;
				
				ArrayList<int[]> arr = new ArrayList<>();
				Q.add(new int[] {k, j});
				vis[k][j] = true;
				arr.add(new int[] {k, j});
				int num = map[k][j], count = 1;
				
				while(!Q.isEmpty()) {
					int[] cur = Q.remove();
					
					for(int i = 0; i < 4; i++) {
						int row = cur[0] + dx[i], col = cur[1] + dy[i];
						
						if(row < 0 || col < 0 || row >= N || col >= N || vis[row][col]) continue;
						
						int m = Math.abs(map[cur[0]][cur[1]] - map[row][col]);
						if(m >= L && m <= R) {
							Q.add(new int[] {row, col});
							vis[row][col] = true;
							res = true;
							num += map[row][col];
							count++;
							arr.add(new int[] {row, col});
						}
					}
				}
				
				num /= count;
				for(int[] cur : arr) map[cur[0]][cur[1]] = num;
			}
		}
		
		return res;
	}
}