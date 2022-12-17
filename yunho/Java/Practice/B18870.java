package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B18870 { //ÁÂÇ¥ ¾ÐÃà
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
	
		int[] ans = new int[n];
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			arr[i] = num;
			ans[i] = num;
		}
		Arrays.sort(arr);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(arr[0], 0);
		int count = 0;
		for(int i = 1; i < n; i++) {
			if(arr[i] == arr[i - 1]) count++;
			map.put(arr[i], i - count);
		}
		for(int i = 0; i < n; i++) sb.append(map.get(ans[i])).append(" ");
		System.out.println(sb);
	}		
}