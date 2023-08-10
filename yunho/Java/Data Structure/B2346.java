package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2346 { //«≥º± ≈Õ∂ﬂ∏Æ±‚
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] balloons = new int[N];
		boolean[] vis = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) balloons[i] = Integer.parseInt(st.nextToken());
		
		int count = 0, index = 0;
		while(count++ <= N) {
			sb.append(index + 1).append(' ');
			vis[index] = true;
			
			if(count == N) break;
			
			int move = balloons[index];
			if(move > 0) {
				while(move-- > 0) {
					index = (index + 1) % N;
					if(vis[index]) move++;
				}
			}
			else {
				while(move++ < 0) {
					index = (index - 1 + N) % N;
					if(vis[index]) move--;
				}
			}
		}
		
		System.out.println(sb);
	}
}