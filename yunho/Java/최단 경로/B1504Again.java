package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504Again { //특정한 최단 경로
	static int N, E; //N : 정점, E : 간선
	static ArrayList<int[]>[] map; //양방향 길, 0 : 정점, 1 : 거리
	static int[] dis; //길이
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) map[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[n1].add(new int[] {n2, d});
			map[n2].add(new int[] {n1, d});
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int[] d = new int[5];
		d[0] = dijkstra(1, v1);
		d[1] = dijkstra(1, v2);
		d[2] = dijkstra(v1, v2);
		d[3] = dijkstra(v1, N);
		d[4] = dijkstra(v2, N);
		
		for(int i = 0; i < 5; i++) {
			if(d[i] == -1) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(Math.min(d[0] + d[2] + d[4], d[1] + d[2] + d[3]));
	}
	
	static int dijkstra(int start, int end) {
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		vis = new boolean[N + 1];
		
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		PQ.add(new int[] {start, 0});
		
		while(!PQ.isEmpty()) {
			int[] cur = PQ.remove();
			int node = cur[0], distance = cur[1];
			
			if(node == end) return distance;
			
			if(vis[node]) continue;
			vis[node] = true;
			
			for(int[] next : map[node]) {
				int n = next[0], d = next[1]; //거리
				
				if(!vis[n] && dis[n] > distance + d) {
					dis[n] = dis[node] + d;
					PQ.add(new int[] {n, dis[n]});
				}
			}
		}
		
		return -1;
	}
}