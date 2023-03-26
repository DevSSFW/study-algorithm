package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14003 { //가장 긴 증가하는 부분 수열 5
	static int N;
	static int[] A, dp, indexOrder, p;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		indexOrder = new int[N];
		p = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		int len = 0;
		dp[0] = A[0];
		indexOrder[0] = 0;
		for(int i = 1; i < N; i++) {
			int temp = b_s(A[i], 0, len);
			indexOrder[i] = temp;
			dp[temp] = A[i];
			if(len < temp) len++;
		}
		
		int ans = len + 1;
		for(int i = N - 1; i >= 0; i--) {
			if(indexOrder[i] == len) {
				p[len] = A[i];
				len--;
			}
		}
		
		sb.append(ans).append('\n');
		for(int i = 0; i < ans; i++) sb.append(p[i]).append(' ');
		System.out.println(sb);
	}

	static int b_s(int key, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(dp[mid] < key) start = mid + 1;
			else if(dp[mid] > key) end = mid - 1;
			else return mid;
		}
		
		return start;
	}
}