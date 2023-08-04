package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2903 { //중앙 이동 알고리즘
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = (int)Math.pow(2, Integer.parseInt(br.readLine())) + 1;
		System.out.println(num * num);
	}
}