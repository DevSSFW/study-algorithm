package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 { //치킨 배달
	static int N, M, ans;
	static int[][] map;
	static ArrayList<int[]> home, chickenAll;
	static int[][] chicken;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		home = new ArrayList<>();
		chickenAll = new ArrayList<>();
		chicken = new int[M][2];
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) home.add(new int[] {i, j});
				else if(map[i][j] == 2) chickenAll.add(new int[] {i, j});
			}
		}
		
		ans = Integer.MAX_VALUE;
		solve(0, 0);
		
		System.out.println(ans);
	}

	static void solve(int index, int count) {
		if(count == M) {
			int res = 0;
			
			for(int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				int[] h = home.get(i);
				
				for(int j = 0; j < M; j++) {
					int[] c = chicken[j];
					
					min = Math.min(min, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
				}
				
				res += min;
			}
			
			ans = Math.min(ans, res);
			
			return;
		}
		
		for(int i = index; i < chickenAll.size(); i++) {
			int[] c = chickenAll.get(i);
			
			chicken[count][0] = c[0];
			chicken[count][1] = c[1];
			solve(i + 1, count + 1);
		}
	}
}