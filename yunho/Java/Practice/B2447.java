package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2447 { //º° Âï±â - 10
	static int iniK;
	static boolean[][] empty;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		iniK = n;
		empty = new boolean[n][n];
		
		star(n);
		
		for(int j = 0; j < n; j++) {
			for(int k = 0; k < n; k++) {
				if(empty[j][k]) bw.write(" ");
				else bw.write("*");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void star(int k) {
		int size = iniK;
		int count = k / 3;
		
		if(k == 1) return;
		
		for(int i = 0; i < size; i++) { //i = row
			for(int j = 0; j < size; j++) { //j = col
				if(i / count % 3 == 1) {
					if(j / count % 3 == 1) empty[i][j] = true;					
				}
			}
		}
		
		star(k / 3);
	}
}