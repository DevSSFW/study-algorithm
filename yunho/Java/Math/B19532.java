package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19532 { //수학은 비대면강의입니다
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x, y;
		int[] a = new int[3], b = new int[3];

		for(int i = 0; i < 3; i++) a[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 3; i++) b[i] = Integer.parseInt(st.nextToken());
	
		for(int i = 1; i < 3; i++) a[i] = a[i] * b[0] - b[i] * a[0];
		y = a[2] / a[1];
		x = (b[2] - b[1] * y) / b[0];
		
		System.out.println(x + " " + y);
	}
}