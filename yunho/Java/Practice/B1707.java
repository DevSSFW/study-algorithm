package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1707 { //이분 그래프
	private static Stack<Integer> s = new Stack<>();
	private static int[] div;
	private static ArrayList<Integer> vis[];
	private static boolean[] visNode;
	private static int V;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			div = new int[V + 1];
			visNode = new boolean[V + 1];
			vis = new ArrayList[V + 1];
			for(int j = 0; j < V + 1; j++) vis[j] = new ArrayList<Integer>();
			for(int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				vis[n1].add(n2);
				vis[n2].add(n1);
			}
			
			if(dfs()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	public static boolean dfs() {
		for(int j = 1; j <= V; j++) {
			if(!visNode[j]) {
				s.add(j);
				visNode[j] = true;
			}
			while(!s.isEmpty()) {
				int cur = s.pop(), size = vis[cur].size();
				
				for(int i = 0; i < size; i++) {
					int x = vis[cur].get(i);
					if(div[cur] != 0 && div[x] != 0 && div[cur] == div[x]) return false;
					if(visNode[x]) continue;
					
					if(div[cur] == 0) div[cur] = 1;
					if(div[x] == 0) div[x] = div[cur] == 1 ? 2 : 1;
					
					visNode[x] = true;
					s.push(x);
				}
			}
		}
		return true;
	}
}