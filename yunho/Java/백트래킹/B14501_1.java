package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501_1 { //퇴사(백트래킹)
	static int N, temp, max;
	static int[] T, P;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		Solve(0);
		
		System.out.println(max);
	}
	
	public static void Solve(int index) {
		if(index >= N) {
			max = Math.max(max, temp);
			return;
		}
		
		for(int i = index; i < N; i++) {
			if(i + T[i] <= N) {
				temp += P[i];
				Solve(i + T[i]);
				temp -= P[i];
			}
		}
		
		max = Math.max(max, temp);
	}
}