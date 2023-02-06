package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2143 { //두 배열의 합
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int N  = Integer.parseInt(br.readLine());
		int[] n = ini(N, br.readLine());
		
		int M  = Integer.parseInt(br.readLine());
		int[] m = ini(M, br.readLine());

		int prev = Integer.MAX_VALUE, indexJ = m.length - 1;
		long countI = 0, countJ = 0, res = 0;
		for(int i = 0; i < n.length; i++) {
			if(prev == n[i]) {
				countI++;
				continue;
			}
			res += countI * countJ;
			
			prev = n[i];
			countI = 1;
			countJ = 0;
			
			while(indexJ >= 0) {
				int num = n[i] + m[indexJ];
				
				if(num < T) break;
				else if(num == T) countJ++;
				
				indexJ--;
			}
		}
		
		res += countI * countJ;
		
		System.out.println(res);
	}

	static int[] ini(int N, String str) {
		StringTokenizer st = new StringTokenizer(str);
		
		int[] num = new int[N];
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int index = 0;
		int[] n = new int[N * (N + 1) / 2];
		for(int i = 0; i < N; i++) {
			n[index++] = num[i];
			for(int j = i + 1; j < N; j++) n[index] = n[index++ - 1] + num[j];
		}
		
		Arrays.sort(n);

		return n;
	}
}