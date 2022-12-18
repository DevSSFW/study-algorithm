package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 { //DFS¿Í BFS
	private static int n, m, v;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		int[][] num = new int[m][2], copyD = new int[n][n], copyB = new int[n][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) num[i][j] = Integer.parseInt(st.nextToken());
			
			int n1 = num[i][0];
			int n2 = num[i][1];
			
			copyD[n1 - 1][n2 - 1] = 1;
			copyD[n2 - 1][n1 - 1] = 1;
			copyB[n1 - 1][n2 - 1] = 1;
			copyB[n2 - 1][n1 - 1] = 1;
		}
		
		visD = new int[n];
		answerD = new int[n];
		dfs(copyD, v);
		answerD = Arrays.copyOf(answerD, countD);
		int[] answerB = bfs(copyB);
		
		for(int i = 0; i < answerD.length; i++) System.out.print(answerD[i] + " ");
		System.out.println();
		for(int i = 0; i < answerB.length; i++) System.out.print(answerB[i] + " ");
	}
	
	private static int[] visD, answerD;
	private static int countD;
	public static void dfs(int[][] copy, int v) {
		answerD[countD++] = v;
		visD[v - 1] = 1;
		
		for(int i = 0; i < n; i++) {
			if(copy[v - 1][i] == 0) continue;
			if(visD[i] == 1) continue;
			
			dfs(copy, i + 1);
		}
	}
	
	public static int[] bfs(int[][] copy) {
		int[][] num = Arrays.copyOf(copy, copy.length);
		int[] answer = new int[n], vis = new int[n];
		int countN = 1;
		
		Queue<Integer> Q = new LinkedList<>();
		Q.add(v);
		vis[v - 1] = 1;
		answer[0] = v;
		
		while(!Q.isEmpty()) {
			int cur = Q.remove();
			
			for(int i = 0; i < n; i++) {
				if(num[cur - 1][i] == 0) continue;
				if(vis[i] == 1) continue;

				answer[countN] = i + 1;
				countN++;
				vis[i] = 1;
				Q.add(i + 1);
			}
		}
		
		answer = Arrays.copyOf(answer, countN);
		return answer;
	}
}