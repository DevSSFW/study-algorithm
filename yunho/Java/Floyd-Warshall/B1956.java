package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1956 { //운동
	static int V, E;
	static int[][] map;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//map 초기화 후 INF 값 설정
		map = new int[V + 1][V + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);
		
		//초기 map
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(map[s][e] > cost) map[s][e] = cost;
		}
		
		floyd_warshall();
		int res = solve();
		
		System.out.println(res == INF ? -1 : res);
	}

	//플로이드-워셜
	static void floyd_warshall(){
		for(int v = 1; v <= V; v++) {
			for(int s = 1; s <= V; s++) {
				if(v == s) continue;
				
				for(int e = 1; e <= V; e++) {
					if(v == e) continue;
					
					map[s][e] = Math.min(map[s][e], map[s][v] + map[v][e]);
				}
			}
		}
	}
	
	static int solve() {
		int min = INF;
		
		for(int i = 1, j = 1; i <= V; i++, j++) min = Math.min(min, map[i][j]);	
		
		return min;
	}
	
	//map 출력
	static void printMap() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) sb.append(map[i][j]).append(' ');
			sb.append('\n');
		}

		System.out.println(sb);
	}
}