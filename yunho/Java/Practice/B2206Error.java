package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206Error { //벽 부수고 이동하기 시간초과
	private static int[][] map, dis; //맵 거리
	private static int n, m; //row col
	private static int[] dRow = {1,0,-1,0}, dCol = {0,1,0,-1};
	private static Queue<int[]> Q;
	private static int len;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) map[i][j] = s.charAt(j) - '0';
		}
		
		Q = new LinkedList<>();
		dis = new int[n][m];
		
		Q.add(new int[] {0, 0});
		dis[0][0] = 1;
			
		bfs();
			
		if(dis[n - 1][m - 1] == 0) len = -1;
		else len = dis[n - 1][m - 1];
		
		System.out.println(len);
	}
	
	public static void bfs() {
		Queue<int[]> W = new LinkedList<>();
		int[][] disW;
		int answer = 0;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
					
			for(int i = 0; i < 4; i++) {
				int row = cur[0] + dRow[i];
				int col = cur[1] + dCol[i];
				
				if(row < 0 || col < 0 || row >= n || col >= m) continue;
				if(dis[row][col] > 0) continue;
				if(map[row][col] == 1) {
					disW = new int[n][m];
					
					W.clear();
					W.add(new int[] {row, col});
					disW[row][col] = dis[cur[0]][cur[1]] + 1;
					
					Loop : while(!W.isEmpty()) {
						int[] curW = W.remove();
						
						for(int ii = 0; ii < 4; ii++) {
							int rowW = curW[0] + dRow[ii];
							int colW = curW[1] + dCol[ii];
							
							if(rowW < 0 || colW < 0 || rowW >= n || colW >= m) continue;
							if(disW[rowW][colW] > 0 || dis[row][col] > 0) continue;
							if(map[rowW][colW] == 1) continue;
							
							W.add(new int[] {rowW, colW});
							disW[rowW][colW] = disW[curW[0]][curW[1]] + 1;
							
							if(rowW == n - 1 && colW == m - 1) break Loop; 
						}
					}
					
					if(disW[n - 1][m - 1] > 0) {
						if(answer == 0) answer = disW[n - 1][m - 1];
						else answer = Math.min(answer, disW[n - 1][m - 1]);					
					}
					
					continue;
				}
				
				Q.add(new int[] {row,col});
				dis[row][col] = dis[cur[0]][cur[1]] + 1;
			}
		}
		
		if(answer > 0) {
			if(dis[n - 1][m - 1] == 0) dis[n - 1][m - 1] = answer;
			else dis[n - 1][m - 1] = Math.min(answer, dis[n - 1][m - 1]);
		}
	}
}