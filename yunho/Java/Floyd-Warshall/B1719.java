package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1719 { //ец╧Х
	static int N, M;
	static int[][] map;
	static String[][] res;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);
		res = new String[N + 1][N + 1];
		for(String[] arr : res) Arrays.fill(arr, "-");
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[s][e] = Math.min(map[s][e], c);
			res[s][e] = "" + e;
			map[e][s] = Math.min(map[e][s], c);
			res[e][s] = "" + s;
		}

		floyd_warshall();
		printMap();
	}
	
	static void floyd_warshall() {
		for(int v = 1; v <= N; v++) {
			for(int s = 1; s <= N; s++) {
				if(v == s) continue;
				
				for(int e = 1; e <= N; e++) {
					if(v == e || s == e) continue;
					
					int temp = map[s][v] + map[v][e];
					if(map[s][e] > temp) {
						map[s][e] = temp;
						res[s][e] = res[s][v];
					}
				}
			}
		}
	}
	
	static void printMap() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) sb.append(res[i][j]).append(' ');
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}