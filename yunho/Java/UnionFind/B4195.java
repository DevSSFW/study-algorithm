package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B4195 { //친구 네트워크
	static int[] root, rank, count;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int F = Integer.parseInt(br.readLine());
			
			root = new int[200001];
			rank = new int[200001];
			count = new int[200001];
			HashMap<String, Integer> friend = new HashMap<>();
			int index = 1;

			while(F-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
			
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				//f1이 키 값으로 없다면 friend와 root에 넣어준다.
				if(!friend.containsKey(f1)) {
					friend.put(f1, index);
					root[index] = index;
					rank[index] = 0;
					count[index++] = 1;
				}
				
				if(!friend.containsKey(f2)) {
					friend.put(f2, index);
					root[index] = index;
					rank[index] = 0;
					count[index++] = 1;
				}
				
				int a = friend.get(f1);
				int b = friend.get(f2);
				
				union(a, b);
				sb.append(count[find(a)]).append('\n');
			}
		}
	
		System.out.println(sb);
	}

	static int find(int x) {
		if(x == root[x]) return x;
		
		return find(root[x]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x == y) return;
		
		if(rank[x] < rank[y]) {
			root[x] = y;
			count[y] += count[x];
		}
		else {
			if(rank[x] == rank[y]) rank[x]++;
			root[y] = x;
			count[x] += count[y]; 
		}
	}
}