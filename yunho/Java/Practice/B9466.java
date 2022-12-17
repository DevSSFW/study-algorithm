package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9466 { //≈“ «¡∑Œ¡ß∆Æ
	private static int[] T;
	private static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			
			T = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) T[j] = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs());
		}
	}

	public static int bfs() {
		int ans = 0;
		
		boolean[] vis = new boolean[n + 1];
		for(int i = 1; i <= n; i++) {
			if(vis[i] == true) continue;
			
			Queue<Integer> Q = new LinkedList<>();
			Queue<Integer> Q2 = new LinkedList<>();
			
			Q.add(T[i]);
			vis[i] = true;
			Q2.add(i);
			
			int re = -1;
			while(!Q.isEmpty()) {
				int cur = Q.remove();
				
				if(vis[cur]) {
					re = cur;
					break;
				}
				
				Q.add(T[cur]);
				vis[cur] = true;
				Q2.add(cur);
			}
			
			while(!Q2.isEmpty()) {
				int cur = Q2.remove();
				
				if(cur == re) break;
				ans++;
			}
		}
		
		return ans;
	}
}