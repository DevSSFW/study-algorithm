package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10818 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
		
		int[] a = new int[n];
		int index = 0;
		
		while(st.hasMoreTokens()) { 
			a[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		
		Arrays.sort(a);
		
		bw.write(a[0] + " " + a[n - 1]);
		bw.flush();
		br.close();
	}
	
}
