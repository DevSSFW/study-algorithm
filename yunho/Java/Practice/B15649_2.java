package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649_2 { //N°ú M(1)
	static int N, M;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		vis = new boolean[N + 1];
		
		solve("", 0);
		System.out.println(sb);
	}

	public static void solve(String s, int count) {
		if(count == M) {
			sb.append(s).append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			String temp = s;
			if(!vis[i]) {
				vis[i] = true;
				temp += i + " ";
				solve(temp , count + 1);
				vis[i] = false;
			}
		}
	}
}