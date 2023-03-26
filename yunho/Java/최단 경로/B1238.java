package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238 { //ÆÄÆ¼
	static int N, M, X;
	static ArrayList<int[]>[] map;
	static int[] res;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) map[i] = new ArrayList<>();
		
		res = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			map[start].add(new int[] {end, T});
		}
		
		for(int i = 1; i <= N; i++) res[i] += dijk(i, X);
		for(int i = 1; i <= N; i++) res[i] += dijk(X, i);
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, res[i]);
			//System.out.println("node : " + i + " dis : " + res[i]);
		}
		
		System.out.println(max);
	}
	
	static int dijk(int from, int to) {
		boolean[] vis = new boolean[N + 1];
		int[] dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		PQ.add(new int[] {from, 0});
		dis[from] = 0;
		
		while(!PQ.isEmpty()) {
			int[] cur = PQ.remove();
			int node = cur[0];
			
			if(vis[node]) continue;
			vis[node] =  true;
			
			if(node == to) return dis[node];
			
			for(int[] n : map[node]) {
				int next = n[0], d = n[1];
				if(vis[next]) continue;
				
				if(dis[next] > dis[node] + d) {
					dis[next] = dis[node] + d;
					PQ.add(new int[] {next, dis[next]});
				}
			}
		}
		
		return 0;
	}
}