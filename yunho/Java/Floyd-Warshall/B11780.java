package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11780 { //플로이드 2
	static int[][] map;
	static String[][] route;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);

		route = new String[N + 1][N + 1];
		for(String[] str : route) Arrays.fill(str, "");

		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//시작 도시에서 도착 도시까지 한번에 가는 값 저장
			if(map[s][e] > cost) {
				map[s][e] = cost;
				route[s][e] = s + " " + e;
			}
		}

		//v : 환승 지점, s : 출발 지점, e : 도착 지점
		for(int v = 1; v <= N; v++) {
			for(int s = 1; s <= N; s++) {
				if(s == v) continue;
				
				for(int e = 1; e <= N; e++) {
					if(s == e || e == v) continue;
					
					int cost = map[s][v] + map[v][e];
					
					//저장되어 있던 가장 최소값과 탐색하고 있는 값 중 작은 값 저장
					if(map[s][e] > cost) {
						map[s][e] = cost;
						
						//환승 번호의 자릿수
						int digit = find_digit(v);
						
						//route[v][e] 더하면 v가 중복된다.
						//v를 중복 제거하기 위해 v와 공백을 더하는 부분에서 뺀다.
						route[s][e] = route[s][v] + " " + route[v][e].substring(digit + 1);
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) sb.append(map[i][j] == INF ? 0 : map[i][j]).append(" ");
			sb.append("\n");
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				StringTokenizer st = new StringTokenizer(route[i][j]);
				
				sb.append(st.countTokens()).append(' ').append(route[i][j]).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	//자릿수 구하기
	static int find_digit(int x) {
		int res = 0;
		
		while(x > 0) {
			x /= 10;
			res++;
		}
		
		return res;
	}
}