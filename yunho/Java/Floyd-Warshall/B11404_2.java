package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11404_2 { //�÷��̵�
	static int[][] map;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);

		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//���� ���ÿ��� ���� ���ñ��� �ѹ��� ���� �� ����
			if(map[start][end] > cost) map[start][end] = cost;
		}
		
		for(int v = 1; v <= N; v++) {
			for(int s = 1; s <= N; s++) {
				if(s == v) continue; //���� ���ÿ� ���� ���ð� ���� �� ����
				
				for(int e = 1; e <= N; e++) {
					if(s == e || e == v) continue; //ȯ�� �ϴ� �κ��� ���� ���ó� ���� ���ÿ� ���� �� ����
					
					//����Ǿ� �ִ� ���� �ּҰ��� Ž���ϰ� �ִ� �� �� ���� �� ����
					map[s][e] = Math.min(map[s][e], map[s][v] + map[v][e]);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) sb.append(map[i][j] == INF ? 0 : map[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}