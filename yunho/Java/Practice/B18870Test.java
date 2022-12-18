package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B18870Test { //ÁÂÇ¥ ¾ÐÃà
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
	
		int[] temp = new int[n];
		int[] ans = new int[n];
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			arr[i] = num;
			ans[i] = num;
		}
		
		Arrays.sort(arr);
		
		List<Integer> arrList = new ArrayList<>();
		arrList.add(arr[0]);
		for(int i = 1; i < n; i++) {
			if(arr[i - 1] != arr[i]) arrList.add(arr[i]);
		}
		
		int size = arrList.size();
		for(int i = 0; i < n; i++) {
			int mid = size / 2, answer = arrList.get(mid), start = 0, end = size;
			
			while(true) {
				if(answer == ans[i]) {
					temp[i] = mid;
					break;
				}
				else if(answer < ans[i]) {
					start = mid;
					mid = (mid + end) / 2;
				}
				else {
					end = mid;
					mid = (start + mid) / 2;
				}
				
				answer = arrList.get(mid);
			}
		}
		
		for(int i = 0; i < n; i++) sb.append(temp[i]).append(" ");
		
		System.out.println(sb);
	}		
}