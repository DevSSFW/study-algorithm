package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1859 { //백만 장자 프로젝트
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) price[j] = Integer.parseInt(st.nextToken());
			
			int temp = price[N - 1], count = 1;
			long sum = price[N - 1], res = 0;
			for(int j = N - 2; j >= 0; j--) {
				if(temp < price[j]) {
					res += Solve(sum, temp, count);
					temp = price[j];
					count = 1;
					sum = price[j];
				}
				
				else {
					sum += price[j];
					count++;
				}
			}
			
			res += Solve(sum, temp, count);
			
			sb.append('#').append(i).append(' ').append(res).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static long Solve(long sum, int num, int count) {
		return num * (count - 1) - (sum - num);
	}
}