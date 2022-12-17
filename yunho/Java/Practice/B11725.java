package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11725 { //트리의 부모 찾기

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n2].add(n1); arr[n1].add(n2);
		}
		
		int[] res = new int[N + 1];
		boolean[] vis = new boolean[N + 1];
		Queue<Integer> Q = new LinkedList<>();
		Q.add(1); vis[1] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.remove();
			
			for(int n : arr[cur]) {
				if(vis[n]) continue;
				vis[n] = true;
				
				res[n] = cur;
				Q.add(n);
			}
		}
		
		for(int i = 2; i <= N; i++) sb.append(res[i]).append("\n");
		System.out.println(sb);
	}
}