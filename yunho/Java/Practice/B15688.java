package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15688 { //수 정렬하기 5
	private static int[] arr, temp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		temp = new int[n];
		arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
		
		merge_Sort(0, n);
		
		for(int i = 0; i < n; i++) sb.append(arr[i]).append("\n");
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
		int mid = (st + en) / 2, firA = st, secA = mid;
		
		for(int i = st; i < en; i++) {
			if(firA == mid) temp[i] = arr[secA++];			
			else if(secA == en) temp[i] = arr[firA++];
			else if(arr[firA] <= arr[secA]) temp[i] = arr[firA++];
			else temp[i] = arr[secA++];
		}
		
		for(int i = st; i < en; i++) arr[i] = temp[i];
	}
}