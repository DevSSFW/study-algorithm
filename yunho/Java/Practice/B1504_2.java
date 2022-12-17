package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504_2 { //특정한 최단 경로
	static int N, E;
	static ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(new int[] {b, c});
			arr.get(b).add(new int[] {a, c});
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
		
		int one = dij(1, v1), two = dij(1, v2), three = dij(v1, v2), four = dij(v1, N), five = dij(v2, N);
		
		if(one == -1 || two == -1 || three == -1 || four == -1 || five == -1) System.out.println(-1);
		else System.out.println(Math.min(one + three + five, two + three + four));
	}
	
	static int dij(int st, int en) {
		boolean[] vis = new boolean[N + 1];
		int[] dis = new int[N + 1];
		Arrays.fill(vis, false); Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		PQ.add(new int[] {st, 0}); dis[st] = 0;
		
		while(!PQ.isEmpty()) {
			int[] cur = PQ.remove();
			int node = cur[0], distance = cur[1];

			if(node == en) return distance;
			
			if(vis[node]) continue;
			vis[node] = true;
			
			for(int[] a : arr.get(node)) {
				int n = a[0], d = a[1] + distance;

				if(vis[n]) continue;
				if(dis[n] > d) {
					dis[n] = d;
					PQ.add(new int[] {n, d});
				}
			}
		}
		
		return -1;
	}
}