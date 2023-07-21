package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11404_2 { //플로이드
	static int[][] map;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);

		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//시작 도시에서 도착 도시까지 한번에 가는 값 저장
			if(map[start][end] > cost) map[start][end] = cost;
		}
		
		for(int v = 1; v <= N; v++) {
			for(int s = 1; s <= N; s++) {
				if(s == v) continue; //시작 도시와 도착 도시가 같을 수 없음
				
				for(int e = 1; e <= N; e++) {
					if(s == e || e == v) continue; //환승 하는 부분이 시작 도시나 도착 도시와 같을 수 없음
					
					//저장되어 있던 가장 최소값과 탐색하고 있는 값 중 작은 값 저장
					map[s][e] = Math.min(map[s][e], map[s][v] + map[v][e]);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) sb.append(map[i][j] == INF ? 0 : map[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}