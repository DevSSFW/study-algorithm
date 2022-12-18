package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 { //¼û¹Ù²ÀÁú

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if(n == k) System.out.println(0);
		else {
			int[] distance = new int[200000];
			Arrays.fill(distance, -1);
				
			Queue<Integer> Q = new LinkedList<>();
			int[] dx = {1, -1};
			
			Q.add(n);
			distance[n] = 0;
			
			Loop : while(!Q.isEmpty()) {
				int cur = Q.remove();
				
				for(int i = 0; i < 3; i++) {
					int x = cur;
					if(i == 2) x *= 2;
					else x += dx[i];
					
					if(x < 0 || x > 100000) continue;
					if(distance[x] != -1) continue;
					
					distance[x] = distance[cur] + 1;
					if(x == k) {
						System.out.println(distance[x]);
						break Loop;
					}
					Q.add(x);
				}
			}
		}
	}
}