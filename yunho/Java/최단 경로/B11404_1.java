package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B11404_1 { //플로이드
	static ArrayList<Node>[] map; //노선도
	static int[][] dis; //가장 짧은 거리
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		//초기화
		map = new ArrayList[N];
		for(int i = 0; i < N; i++) map[i] = new ArrayList<>();
		dis = new int[N][N];
		
		//map에 노선 추가
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end, cost));
		}
		
		//dis의 모든 값 최대치로 설정
		for(int[] arr : dis) Arrays.fill(arr, Integer.MAX_VALUE);
		
		for(int i = 0; i < N; i++) {
			Queue<Integer> Q = new LinkedList<>();
			dis[i][i] = 0;
			Q.add(i);
			
			while(!Q.isEmpty()) {
				int cur = Q.remove();
				
				//현재 정거장에서 갈 수 있는 모든 정거장 탐색
				for(Node node : map[cur]) {
					int end = node.end, cost = node.cost;
					
					//기존에 저장되어 있는 다음 정거장까지 가는 가장 짧은 값 - A
					//기존에 저장되어 있는 현재 정거장까지 가는 가장 짧은 값 + 현재 정거장에서 다음 정거장까지 가는 비용 - B
					//A > B 라면 B를 dis[i][end]에 저장
					if(dis[i][end] > dis[i][cur] + cost) {
						dis[i][end] = dis[i][cur] + cost; //B를 dis[i][end]에 저장
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