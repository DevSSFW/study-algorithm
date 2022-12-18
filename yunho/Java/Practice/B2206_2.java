package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206_2 { //�� �μ��� �̵��ϱ�
	static int N, M;
	static int[][] map;
	static boolean[][] vis, vis_crash; //vis : �ѹ��� �μ��� ���� ���·� �湮, vis_crash : �ѹ� �μ� ���·� �湮
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
				
				if(r < 0 || c < 0 || r >= N || c >= M || vis[r][c]) continue; //�ѹ��� �μ��� ���� ���¿��� �湮������ �� �ٽ� �湮�� �ʿ䰡 ����.
				if(map[r][c] == 1 && crash) continue; //���� �ѹ� �ν� ���¿��� ���� ������ ��
				else if(crash) { //���� �ѹ� �μ� ���¿��� �̵��� �� �ִ� ������ ���� ��
					if(vis_crash[r][c]) continue; //�ѹ� �μ� ���¿��� �̹� �湮 ������ �湮�� �ʿ䰡 ����.
					
					Q.add(new Pair(r, c, count + 1, true));
					vis_crash[r][c] = true; //�ѹ� �μ� ���¿��� �湮������ �����.
					continue;
				}
				else if(map[r][c] == 1) { //���� �ѹ��� �μ��� ���� ���¿��� ���� ������ ��
					Q.add(new Pair(r, c, count + 1, true));
					vis[r][c] = true; //�ѹ��� �μ��� ���� ���¿��� �湮������ �����.
					continue;
				}
				else { //���� �ѹ��� �μ��� ���� ���¿��� �̵��� �� �ִ� ������ ���� ��
					Q.add(new Pair(r, c, count + 1, false));
					vis[r][c] = true; //�ѹ��� �μ��� ���� ���¿��� �湮������ �����.
				}
			}
		}
		
		return -1; //���������� �̵����� ������ ���
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