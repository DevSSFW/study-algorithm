package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class B15663 { //N°ú M (9)
	static int N, M;
	static int[] num, arr;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashMap<String, Boolean> res = new LinkedHashMap<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		num = new int[N]; arr = new int[M];
		vis = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		solve(0);
		
		for(String s : res.keySet()) sb.append(s).append("\n");
		System.out.println(sb);
	}
	
	static void solve(int count) {
		if(count == M) {
			String s = "";
			for(int i = 0; i < M; i++) s += arr[i] + " ";
			
			if(!res.containsKey(s)) res.put(s, false);

			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!vis[i]) {
				vis[i] = true;
				arr[count] = num[i];
				solve(count + 1);
				vis[i] = false;
			}
		}
	}
}