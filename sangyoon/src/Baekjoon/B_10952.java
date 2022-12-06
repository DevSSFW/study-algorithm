package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10952 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0) {
				break;
			}
			sb.append(a + b).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
}
