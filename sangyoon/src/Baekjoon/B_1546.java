package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1546 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double array[] = new double[Integer.parseInt(br.readLine())];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < array.length; i++) {
			array[i] = Double.parseDouble(st.nextToken());
		}
		
		Arrays.sort(array);
		double sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			sum += ((array[i] / array[array.length - 1]) * 100);
		}
		
		System.out.println(sum / array.length);
	}

}
