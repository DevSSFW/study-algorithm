package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14938 { //서강그라운드
	static int N, M, R; //N : 지역의 개수, M : 수색범위, R : 길의 개수
	static int[][] map;
	static int[] item;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		//item 초기화 후 값 설정
		item = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; st.hasMoreTokens(); i++) item[i] = Integer.parseInt(st.nextToken());
		
		//map 초기화 후 INF 값 설정
		map = new int[N + 1][N + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);
		
		//초기 map
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(map[s][e] > cost) map[s][e] = cost;
			if(map[e][s] > cost) map[e][s] = cost;
		}
		
		floyd_warshall();
		int res = solve();
		
		System.out.println(res);
	}

	//플로이드-워셜
	static void floyd_warshall(){
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
	
	static int solve() {
		int res = 0;
		
		for(int i = 1; i <= N; i++) {
			int getItem = item[i];
			
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == INF || map[i][j] > M) continue;
				
				getItem += item[j];
			}
			
			res = Math.max(res, getItem);
		}
		
		return res;
	}
	
	//map 출력
	static void printMap() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) sb.append(map[i][j]).append(' ');
			sb.append('\n');
		}

		System.out.println(sb);
	}
}