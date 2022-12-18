package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1431 { //시리얼 번호
	private static String[] arr, temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new String[n];
		temp = new String[n];
		for(int i = 0; i < n; i++) arr[i] = br.readLine();
		
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
		int mid = (st + en) / 2, firArr = st, secArr = mid;
		
		for(int i = st; i < en; i++) {
			if(firArr == mid) temp[i] = arr[secArr++];
			else if(secArr == en) temp[i] = arr[firArr++];
			else if(arr[firArr].length() < arr[secArr].length()) temp[i] = arr[firArr++];
			else if(arr[firArr].length() == arr[secArr].length()) {
				int firSum = 0, secSum = 0;
				
				for(int j = 0; j < arr[firArr].length(); j++) {
					if(arr[firArr].charAt(j) >= 48 && arr[firArr].charAt(j) <= 57) firSum += arr[firArr].charAt(j) - '0';
					if(arr[secArr].charAt(j) >= 48 && arr[secArr].charAt(j) <= 57) secSum += arr[secArr].charAt(j) - '0';
				}
				
				if(firSum == secSum) {
					for(int j = 0; j < arr[firArr].length(); j++) {
						if(arr[firArr].charAt(j) == arr[secArr].charAt(j)) continue;
						else if(arr[firArr].charAt(j) < arr[secArr].charAt(j)) {
							temp[i] = arr[firArr++];
							break;
						}
						else {
							temp[i] = arr[secArr++];
							break;
						}
					}
				}
				else if(firSum < secSum) temp[i] = arr[firArr++];
				else temp[i] = arr[secArr++];
			}
			else temp[i] = arr[secArr++];
		}
		
		for(int i = st; i < en; i++) arr[i] = temp[i];
	}
}