package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B20303 { //�ҷ����� ���ġ
	static int K; //K : �����Ҹ� �ּ� ������ ��
	static int[] candy, parent, rank, dp;
	static HashMap<Integer, int[]> leader;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //N : �Ÿ��� �ִ� ���̵��� ��
		int M = Integer.parseInt(st.nextToken()); //M : ģ�� ���� ��
		K = Integer.parseInt(st.nextToken());
		
		candy = new int[N + 1];
		parent = new int[N + 1];
		rank = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
			rank[i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		make_leader(N);
		
		System.out.println(knapsack());
	}
	
	static int knapsack() {
		int[] dp = new int[K + 1];
		
		for(int l : leader.keySet()) {
			int[] has = leader.get(l);
			int candy = has[0], children = has[1];
			
			for(int i = K; i > children; i--) dp[i] = Math.max(dp[i], dp[i - children] + candy);
		}
		
		return dp[K]; 
	}
	
	//leader : ����, ������ ����� ������ ��� ģ������ ������ �����.
	//leader�� value���� ������ ���� ����� ģ���� ���� ����ȴ�.
	//has[0] : ���� ��, has[1] : ����� ��� ��
	static void make_leader(int N) {
		leader = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			int friend = find(i);
			
			if(leader.containsKey(friend)) {
				int[] has = leader.get(friend);
				
				has[0] += candy[i];
				has[1]++;
			
				leader.put(friend, has);
			}
			else {
				int[] has = new int[2];
				
				has[0] = candy[i];
				has[1] = 1;
				
				leader.put(friend, has);
			}
		}
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		
		return find(parent[x]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x != y) {
			if(rank[x] == rank[y]) {
				parent[y] = x;
				rank[x]++;
			}
			else if(rank[x] > rank[y]) parent[y] = x;
			else parent[x] = y;
		}
	}
}