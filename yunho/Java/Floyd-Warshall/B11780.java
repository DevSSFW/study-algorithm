package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11780 { //�÷��̵� 2
	static int[][] map;
	static String[][] route;
	static final int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for(int[] arr : map) Arrays.fill(arr, INF);

		route = new String[N + 1][N + 1];
		for(String[] str : route) Arrays.fill(str, "");

		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//���� ���ÿ��� ���� ���ñ��� �ѹ��� ���� �� ����
			if(map[s][e] > cost) {
				map[s][e] = cost;
				route[s][e] = s + " " + e;
			}
		}

		//v : ȯ�� ����, s : ��� ����, e : ���� ����
		for(int v = 1; v <= N; v++) {
			for(int s = 1; s <= N; s++) {
				if(s == v) continue;
				
				for(int e = 1; e <= N; e++) {
					if(s == e || e == v) continue;
					
					int cost = map[s][v] + map[v][e];
					
					//����Ǿ� �ִ� ���� �ּҰ��� Ž���ϰ� �ִ� �� �� ���� �� ����
					if(map[s][e] > cost) {
						map[s][e] = cost;
						
						//ȯ�� ��ȣ�� �ڸ���
						int digit = find_digit(v);
						
						//route[v][e] ���ϸ� v�� �ߺ��ȴ�.
						//v�� �ߺ� �����ϱ� ���� v�� ������ ���ϴ� �κп��� ����.
						route[s][e] = route[s][v] + " " + route[v][e].substring(digit + 1);
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) sb.append(map[i][j] == INF ? 0 : map[i][j]).append(" ");
			sb.append("\n");
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				StringTokenizer st = new StringTokenizer(route[i][j]);
				
				sb.append(st.countTokens()).append(' ').append(route[i][j]).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	//�ڸ��� ���ϱ�
	static int find_digit(int x) {
		int res = 0;
		
		while(x > 0) {
			x /= 10;
			res++;
		}
		
		return res;
	}
}