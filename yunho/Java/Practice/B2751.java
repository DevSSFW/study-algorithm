package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2751 { //수 정렬하기 2, Merge Sort
	private static int arr[], temp[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
		
		temp = new int[n];
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
		int mid = (st + en) / 2, arrF = st, arrS = mid;
		
		for(int i = st; i < en; i++) {
			if(arrF == mid) {
				temp[i] = arr[arrS++];
				continue;
			}
			else if(arrS == en) {
				temp[i] = arr[arrF++];
				continue;
			}
			if(arr[arrF] <= arr[arrS]) temp[i] = arr[arrF++];
			else temp[i] = arr[arrS++];
		}
		
		for(int i = st; i < en; i++) arr[i] = temp[i];
	}
}