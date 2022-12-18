package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9019_2 { //DSLR

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
	
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int ini = Integer.parseInt(st.nextToken()), res = Integer.parseInt(st.nextToken());
			
			int[] parent = new int[10000];
			boolean[] vis = new boolean[10000];
			char[] printR = new char[10000];
			Queue<Integer> Q = new LinkedList<>();
			Q.add(ini);
			vis[ini] = true;
			parent[ini] = ini;
			
			while(!Q.isEmpty()) {
				int cur = Q.remove();
				
				if(cur == res) {
					String s = "";
					
					while(cur != ini) {
						s = printR[cur] + s;
						cur = parent[cur];
					}
					
					sb.append(s).append("\n");
					break;
				}
				
				int n = (cur % 1000) * 10 + cur / 1000;
				if(!vis[n]) { //L
					Q.add(n);
					printR[n] = 'L';
					parent[n] = cur;
					vis[n] = true;
				}
				
				n = (cur % 10) * 1000 + cur / 10;
				if(!vis[n]) { //R
					Q.add(n);
					printR[n] = 'R';
					parent[n] = cur;
					vis[n] = true;
				}
				
				n = (cur * 2) % 10000;
				if(!vis[n]) { //D
					Q.add(n);
					printR[n] = 'D';
					parent[n] = cur;
					vis[n] = true;
				}
				
				n = cur == 0 ? 9999 : cur - 1;
				if(!vis[n]) { //S
					Q.add(n);
					printR[n] = 'S';
					parent[n] = cur;
					vis[n] = true;
				}
			}
		}
		
		System.out.println(sb);
	}
}