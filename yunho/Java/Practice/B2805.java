package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2805 { //나무 자르기

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //나무 개수
		long m = Long.parseLong(st.nextToken()); //구해야 할 나무 길이
		Long[] t = new Long[n]; //나무

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) t[i] = Long.parseLong(st.nextToken());
		Arrays.sort(t, Collections.reverseOrder());
		
		long big = t[0], cut = 0, result = 0, count = 1;
		
		for(int i = 1; i < n; i++) {
			if(big == t[i]) {
				count++;
				continue;
			}
			cut = (big - t[i]) * count;
			result = t[i];
			if(cut >= m) {
				if(cut == m) {
					m = -1;
					break;
				}
				for(; cut > m; cut -= count) result++;
				if(cut != m) result--;
				m = -1;
				break;
			}
			else {
				m -= cut;
				big = t[i];
				count++;
			}
		}
		
		long all = big;
		while(m > 0) {
			if(big == t[0]) {
				m -= count;
				result = --all;
			}
			else {
				m -= count;
				result--;
			}
		}
		
		System.out.println(result);
	}
}
