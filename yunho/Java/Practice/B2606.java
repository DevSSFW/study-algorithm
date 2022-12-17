package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2606 { //바이러스
	private static ArrayList<Integer> com[];
	private static int n;
	private static boolean vis[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		vis = new boolean[n + 1];
		com = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) com[i] = new ArrayList<>();

		int line = Integer.parseInt(br.readLine());
		for(int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			com[c1].add(c2);
			com[c2].add(c1);
		}
		
		System.out.println(bfs());
	}
	public static int bfs() {
		int count = -1;
		Queue<Integer> Q = new LinkedList<>();
		
		Q.add(1);
		vis[1] = true;
		while(!Q.isEmpty()) {
			int cur = Q.remove();
			
			count++;
			for(int i = 1; i <= n; i++) {
				if(!com[cur].contains(i) || vis[i]) continue;
				
				com[cur].remove(com[cur].indexOf(i));
				com[i].remove(com[i].indexOf(cur));
				
				Q.add(i);
				vis[i] = true;
			}
		}
		
		return count;
	}
}