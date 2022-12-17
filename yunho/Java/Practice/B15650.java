package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 { //N°ú M (2)
	private static StringBuilder sb = new StringBuilder();
	private static int N, M, count = 0;
	private static int[] arr;
	private static boolean[] vis;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		vis = new boolean[N + 1];
		
		search(0);
		
		System.out.println(sb);
	}
	public static void search(int k) {
		if(k == M) {
			for(int i = 0; i < M; i++) sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!vis[i]) {
				if(k > 0 && arr[k - 1] >= i) continue;
				arr[k] = i;
				vis[i] = true;
				search(k + 1);
				vis[i] = false;
			}
		}
	}
}