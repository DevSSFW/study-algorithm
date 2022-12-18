package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B3273 { //두 수의 합

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer[] a = new Integer[n];
		
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a, Collections.reverseOrder());
		
		int x = Integer.parseInt(br.readLine());
		
		System.out.println(X(a, x));
	}
	
	public static int X(Integer[] a, int x) {
		int lastIndex = a.length - 1, result = 0, compare;
		Loop : for(int i = 0; i < a.length - 1; i++) {
			if(a[i] >= x) continue;
			int count = 0;
			if(i == lastIndex) break;
			while((compare = a[i] + a[lastIndex  - count]) < x) {
				if(lastIndex - count == 1) break Loop;
				count++;
				if(lastIndex - count == i) break Loop;
			}
			if(compare == x) result++;
			lastIndex -= count;
		}		
		return result;
	}
}
