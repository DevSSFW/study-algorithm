package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge_Sort {
	private static int[] arr, temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		temp = new int[n];
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		merge_Sort(0, n);
	
		for(int i = 0; i < n; i++) sb.append(arr[i]).append(" ");
		
		System.out.println(sb);
	}

	public static void merge_Sort(int st, int en) {
		if(st + 1 == en) return;
		
		int mid = (st + en) / 2;
		
		merge_Sort(st, mid);
		merge_Sort(mid, en);
		merge(st, en);
	}
	
	public static void merge(int st, int en) {
		int mid = (st + en) / 2, firArr = st, secArr = mid;
		
		for(int i = st; i < en; i++) {
			if(firArr == mid) temp[i] = arr[secArr++];
			else if(secArr == en) temp[i] = arr[firArr++];
			else if(arr[firArr] <= arr[secArr]) temp[i] = arr[firArr++];
			else temp[i] = arr[secArr++];
		}
		
		for(int i = st; i < en; i++) arr[i] = temp[i];
	}
}