package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10159 { //저울
	static int N, M;
	static int[][] map;
	static int[] ans;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		//초기화
		ans = new int[N + 1];
		map = new int[N + 1][N + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);
	
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			map[s][e] = 1;
		}
		
		floyd_warshall();
		solve();
	}
	
	static void floyd_warshall() {
		for(int v = 1; v <= N; v++) {
			for(int s = 1; s <= N; s++) {
				if(v == s) continue;
				
				for(int e = 1; e <= N; e++) {
					if(v == e || s == e) continue;
					
					map[s][e] = Math.min(map[s][e], map[s][v] + map[v][e]);
				}
			}
		}
	}
	
	static void solve() {
		StringBuilder sb = new StringBuilder();
	
		//reverse map
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] != INF) map[j][i] = -map[i][j];
			}
		}
		
		//count item
		//if map[i][j] is INF, ans[i] is incremented by one
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				if(map[i][j] == INF) ans[i]++;
			}
		}
		
		for(int i = 1; i <= N; i++) sb.append(ans[i]).append('\n');
		
		System.out.println(sb);
	}
	
	//map 출력
	static void printMap() {
		StringBuilder sb = new StringBuilder();
			
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == INF) sb.append("0 ");
				else sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}