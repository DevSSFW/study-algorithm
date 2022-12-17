package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10814 { //나이순 정렬
	private static int[] arr, temp;
	private static String[] name, tempN;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		temp = new int[n];
		tempN = new String[n];
		arr = new int[n];
		name = new String[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			name[i] = st.nextToken();
		}
		
		merge_Sort(0, n);
		
		for(int i = 0; i < n; i++) sb.append(arr[i]).append(" ").append(name[i]).append("\n");
		
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
			if(firA == mid) {
				temp[i] = arr[secA];
				tempN[i] = name[secA++];
			}
			else if(secA == en) {
				temp[i] = arr[firA];
				tempN[i] = name[firA++];
			}
			else if(arr[firA] <= arr[secA]) {
				temp[i] = arr[firA];
				tempN[i] = name[firA++];
			}
			else {
				temp[i] = arr[secA];
				tempN[i] = name[secA++];
			}
		}
		
		for(int i = st; i < en; i++) {
			arr[i] = temp[i];
			name[i] = tempN[i];
		}
	}
}