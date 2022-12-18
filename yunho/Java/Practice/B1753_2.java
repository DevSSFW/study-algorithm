package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753_2 { //최단경로
	static boolean[] vis;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer>[] map = new HashMap[V + 1];
		for(int i = 1; i <= V; i++) map[i] = new HashMap<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(map[u].containsKey(v) && map[u].get(v) <= w) continue;
			map[u].put(v, w);
		}

		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		int[] len = new int[V + 1];
		Arrays.fill(len, Integer.MAX_VALUE);
		vis = new boolean[V + 1];
		
		PQ.add(new int[] {0, K});
		len[K] = 0;
		
		while(!PQ.isEmpty()) {
			int[] cur = PQ.remove();
			int length = cur[0], node = cur[1];
			
			if(vis[node]) continue;
			vis[node] = true;
			
			for(Integer i : map[node].keySet()) {
				if(vis[i]) continue;
				
				int l = map[node].get(i) + length;
				if(len[i] > l) {
					len[i] = l;
					PQ.add(new int[] {l, i});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(!vis[i]) sb.append("INF").append("\n");
			else sb.append(len[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}