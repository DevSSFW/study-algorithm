package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW12052 { //부서진 타일
	static int N, M;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			
			for(int j = 0; j < N; j++) {
				String str = br.readLine();
				
				for(int k = 0; k < M; k++) map[j][k] = str.charAt(k);
			}
			
			sb.append('#').append(i).append(' ');
			if(Solve()) sb.append("YES");
			else sb.append("NO");
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static boolean Solve() {
		int[] dx = {0, 1, 0, 1}, dy = {0, 0, 1, 1};
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '.') continue;
				
				for(int k = 0; k < 4; k++) {
					int col = i + dx[k];
					int row = j + dy[k];
					
					if(col >= N || row >= M || map[col][row] == '.') return false;
					
					map[col][row] = '.';
				}
			}
		}
		
		return true;
	}
}