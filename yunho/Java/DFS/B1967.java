package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1967 { //트리의 지름
	static int N, max_length;
	static ArrayList<int[]>[] map;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) map[i] = new ArrayList<>();
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[parent].add(new int[] {child, w});
		}
		
		solve(1);
		System.out.println(max_length);
	}
	
	static int solve(int n) {
		int max_weight = 0; //자식 노드 중 제일 긴 가중치
		for(int[] node : map[n]) {
			//자신부터 자식 노드 중 리프 노드까지의 가중치
			int child_weight = solve(node[0]);
			node[1] += child_weight;
			
			max_length = Math.max(max_length, max_weight + node[1]);
			max_weight = Math.max(max_weight, node[1]);
		}
		
		return max_weight;
	}
}