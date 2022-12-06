package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10871 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		 
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
 
			if (value < x)
				sb.append(value).append(' ');
		}
		System.out.println(sb);
		
		br.close();
	}
	
}
