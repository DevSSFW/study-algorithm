package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1181 { //단어 정렬
	private static String[] arr, temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		temp = new String[n];
		arr = new String[n];
		for(int i = 0; i < n; i++) arr[i] = br.readLine();
		
		merge_Sort(0, n);
		
		for(int i = 0; i < n; i++) {
			if(i == 0) sb.append(arr[i]).append("\n");
			else if(!arr[i].equals(arr[i - 1])) sb.append(arr[i]).append("\n");
		}
		
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
			else if(arr[firA].length() < arr[secA].length()) temp[i] = arr[firA++];
			else if(arr[firA].length() == arr[secA].length()) { //0이면 앞, 1이면 뒤
				if(alpha(arr[firA], arr[secA], 0) == 0) temp[i] = arr[firA++];
				else temp[i] = arr[secA++];
			}
			else temp[i] = arr[secA++];
		}
		
		for(int i = st; i < en; i++) arr[i] = temp[i];
	}
	
	public static int alpha(String fir, String sec, int i) {
		if(i >= fir.length()) return 1;
		else if(i >= sec.length()) return 0;
		else if(fir.charAt(i) == sec.charAt(i)) return alpha(fir, sec, ++i);
		else if(fir.charAt(i) - '0' <= sec.charAt(i) - '0') return 0;
		else return 1;
	}
}
