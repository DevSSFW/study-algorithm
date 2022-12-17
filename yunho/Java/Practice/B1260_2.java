package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B1260_2 { //DFS¿Í BFS
	private static int N, M;
	private static TreeMap<Integer, Boolean>[] map;
	private static StringBuilder sb = new StringBuilder();
	private static boolean[] vis;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		vis = new boolean[N + 1];
		map = new TreeMap[N + 1];
		for(int i = 0; i <= N; i++) map[i] = new TreeMap<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			map[n1].put(n2, true); map[n2].put(n1, true);
		}
		
		dfs(v);
		vis = new boolean[N + 1];
		sb.append("\n");
		bfs(v);
		
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		sb.append(v).append(" ");
		vis[v] = true;
		
		for(Integer i : map[v].keySet()) {
			if(vis[i]) continue;
			dfs(i);
		}
	}
	static void bfs(int v) {
		Queue<Integer> Q = new LinkedList<>();
		
		Q.add(v);
		vis[v] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.remove();
			sb.append(cur).append(" ");
			
			for(Integer i : map[cur].keySet()) {
				if(vis[i]) continue;
				
				Q.add(i);
				vis[i] = true;
			}
		}
	}
}