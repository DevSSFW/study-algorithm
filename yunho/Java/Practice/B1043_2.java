package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1043_2 { //거짓말, union_find 구조 사용
	static int[] root, rank;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		root = new int[N + 1]; rank = new int[N + 1];
		for(int i = 1; i <= N; i++) root[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] know = new int[T];
		for(int i = 0; i < T; i++) know[i] = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[M];
		for(int i = 0; i < M; i++) {
			arr[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			arr[i].add(n1);
			for(int j = 1; j < count; j++) {
				int n2 = Integer.parseInt(st.nextToken());
				arr[i].add(n2);
				union(n1, n2);
			}
		}
		
		boolean[] vis = new boolean[N + 1];
		for(int i = 0; i < T ; i++) {
			if(vis[know[i]]) continue;
			vis[know[i]] = true;
			
			int temp = find(know[i]);
			for(int j = 1; j <= N; j++) {
				if(temp == find(j)) vis[j] = true;
			}
		}
		
		int ans = 0;
		for(int i = 0; i < M; i++) {
			if(!vis[arr[i].get(0)]) ans++;
		}
		
		System.out.println(ans);
	}

	static int find(int x) {
		if(x == root[x]) return x;
		return root[x] = find(root[x]);
	}
	
	static void union(int x, int y) {
		x = find(x); y = find(y);
		
		if(x == y) return;
		
		if(rank[x] > rank[y]) root[y] = x;
		else {
			root[x] = y;
			
			if(rank[x] == rank[y]) rank[y]++;
		}
	}
}
