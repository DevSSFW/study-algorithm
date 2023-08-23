package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15657 { //N°ú M (8)
	static int N, M;
	static int[] num, temp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		temp = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);
		Solve(0, 0);
		System.out.println(sb);
	}
	
	static void Solve(int index, int count) {
		if(count == M) {
			for(int i = 0; i < M; i++) sb.append(temp[i] + " ");
			sb.append('\n');
			
			return;
		}
		
		for(int i = index; i < N; i++) {
			temp[count] = num[i];
			Solve(i, count + 1);
		}
	}
}