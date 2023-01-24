package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B13306 { //Æ®¸®
	static int[] node, p;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
		
		node = new int[N + 1];
		p = new int[N + 1];
		node[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			node[i] = i;
			p[i] = n;
		}
		
		Stack<String> S = new Stack<>();
		for(int i = 0; i < N + Q - 1; i++) S.add(br.readLine());
		
		Stack<String> ans = new Stack<>();
		while(!S.isEmpty()) {
			st = new StringTokenizer(S.pop());

			int[] cur = new int[3];
			int index = 0;
			while(st.hasMoreElements()) cur[index++] = Integer.parseInt(st.nextToken());
			
			if(cur[0] == 0) union(cur[1], p[cur[1]]);
			else {
				if(find(cur[1]) == find(cur[2])) ans.add("YES");
				else ans.add("NO");
			}
		}
		
		while(!ans.isEmpty()) sb.append(ans.pop() + "\n");
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(node[x] == x) return x;
		else return node[x] = find(node[x]);
	}
	
	static void union(int x, int y) {
		int o1 = find(x);
		int o2 = find(y);
		
		if(o1 == o2) return;
		if(node[o1] <= node[o2]) node[o2] = o1;
		else node[o1] = o2;
	}
}