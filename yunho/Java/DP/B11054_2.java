package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11054_2 { //가장 긴 바이토닉 부분 수열
	static int N;
	static int[] num, dp1, dp2, temp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		dp1 = new int[N];
		dp2 = new int[N];
		temp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int index = 0;
		temp[0] = num[0];
		dp1[0] = 1;
		for(int i = 1; i < N; i++) {
			dp1[i] = dp1[i - 1];
			
			if(temp[index] < num[i]) {
				dp1[i]++;
				temp[++index] = num[i];
			}
			else LowerBound(num[i], 0, index);
		}
		
		temp = new int[N];
		index = 0;
		temp[0] = num[N - 1];
		dp2[N - 1] = 1;
		for(int i = N - 2; i >= 0; i--) {
			dp2[i] = dp2[i + 1];
			
			if(temp[index] < num[i]) {
				dp2[i]++;
				temp[++index] = num[i];
			}
			else LowerBound(num[i], 0, index);
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) max = Math.max(max, dp1[i] + dp2[i]);
		
		System.out.println(max - 1);
	}
	
	public static void LowerBound(int key, int start, int end) {
		if(start >= end) {
			temp[end] = key;
			return;
		}

		int mid = (start + end) / 2;
		
		if(temp[mid] >= key) LowerBound(key, start, mid);
		else LowerBound(key, mid + 1, end);
	}
}