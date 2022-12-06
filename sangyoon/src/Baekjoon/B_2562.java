package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2562 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int[] n = new int[9];
		
		for (int i = 0; i < 9; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		int index = 0;
		int count = 0;
		
		for (int value : n) {
			count++;
			if(value > max) {
				max = value;
				index = count;
			}
		}
		
		bw.write(max + "\n" + index);
		bw.flush();
		br.close();
	}
	
}
