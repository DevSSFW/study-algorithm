package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B15666 { //N°ú M (12)
	static int N, M;
	static ArrayList<Integer> num;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new ArrayList<>();
		temp = new int[M];
		boolean[] vis = new boolean[10001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(vis[n]) continue;
			
			num.add(n);
			vis[n] = true;
		}
		
		Collections.sort(num);
		Solve(0, 0);
		System.out.println(sb);
	}
	
	static void Solve(int index, int count) {
		if(count == M) {
			for(int i = 0; i < M; i++) sb.append(temp[i]).append(' ');
			sb.append('\n');
			
			return;
		}
		
		for(int i = index; i < num.size(); i++) {
			temp[count] = num.get(i);
			Solve(i, count + 1);
		}
	}
}