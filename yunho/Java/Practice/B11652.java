package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11652 { //Ä«µå
	private static long[][] temp, t;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) arr[i] = Long.parseLong(br.readLine());
		Arrays.sort(arr);
		
		int count = 0;
		temp = new long[n][2];
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				temp[0][0]++;
				temp[0][1] = arr[0];
			}
			else {
				if(arr[i] == arr[i - 1]) temp[count][0]++;
				else {
					count++;
					temp[count][0]++;
					temp[count][1] = arr[i];
				}
			}
		}
		
		t = new long[count + 1][2];
		merge_Sort(0, count + 1);
		System.out.println(temp[0][1]);
	}
	public static void merge_Sort(int st, int en) {
		if(st + 1 >= en) return;
		
		int mid = (st + en) / 2;
		
		merge_Sort(st, mid);
		merge_Sort(mid, en);
		merge(st, en);
	}
	
	public static void merge(int st, int en) {
		int mid = (st + en) / 2, firArr = st, secArr = mid;
		
		for(int i = st; i < en; i++) {
			if(firArr == mid) {
				t[i][1] = temp[secArr][1];
				t[i][0] = temp[secArr++][0];
			}
			else if(secArr == en) {
				t[i][1] = temp[firArr][1];
				t[i][0] = temp[firArr++][0];
			}
			else if(temp[firArr][0] >= temp[secArr][0]) {
				t[i][1] = temp[firArr][1];
				t[i][0] = temp[firArr++][0];
			}
			else {
				t[i][1] = temp[secArr][1];
				t[i][0] = temp[secArr++][0];
			}
		}
		
		for(int i = st; i < en; i++) {
			temp[i][1] = t[i][1];
			temp[i][0] = t[i][0];
		}
	}
}