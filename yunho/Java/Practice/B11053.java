package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053 { //가장 긴 증가하는 부분 수열

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N], len = new int[N];	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
	
		int max = 1;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(num[j] < num[i]) len[i] = Math.max(len[i], len[j] + 1);
			}
			
			max = Math.max(max, len[i] + 1);
		}
		
		System.out.println(max);
	}
}