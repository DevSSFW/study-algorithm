package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B11404_1 { //�÷��̵�
	static ArrayList<Node>[] map; //�뼱��
	static int[][] dis; //���� ª�� �Ÿ�
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		//�ʱ�ȭ
		map = new ArrayList[N];
		for(int i = 0; i < N; i++) map[i] = new ArrayList<>();
		dis = new int[N][N];
		
		//map�� �뼱 �߰�
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end, cost));
		}
		
		//dis�� ��� �� �ִ�ġ�� ����
		for(int[] arr : dis) Arrays.fill(arr, Integer.MAX_VALUE);
		
		for(int i = 0; i < N; i++) {
			Queue<Integer> Q = new LinkedList<>();
			dis[i][i] = 0;
			Q.add(i);
			
			while(!Q.isEmpty()) {
				int cur = Q.remove();
				
				//���� �����忡�� �� �� �ִ� ��� ������ Ž��
				for(Node node : map[cur]) {
					int end = node.end, cost = node.cost;
					
					//������ ����Ǿ� �ִ� ���� ��������� ���� ���� ª�� �� - A
					//������ ����Ǿ� �ִ� ���� ��������� ���� ���� ª�� �� + ���� �����忡�� ���� ��������� ���� ��� - B
					//A > B ��� B�� dis[i][end]�� ����
					if(dis[i][end] > dis[i][cur] + cost) {
						dis[i][end] = dis[i][cur] + cost; //B�� dis[i][end]�� ����
						Q.add(end);
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dis[i][j] == Integer.MAX_VALUE) sb.append("0").append(" ");
				else sb.append(dis[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Node {
		int end, cost;
		
		Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
}