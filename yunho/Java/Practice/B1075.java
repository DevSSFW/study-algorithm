package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1075 { //³ª´©±â

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= F; i++) {
			String s = "" + (N / 100);
			
			if(i < 10) s += "0" + i;
			else s += i;
			
			int num = Integer.parseInt(s);
			if(num % F == 0) {
				System.out.println(s.substring(s.length() - 2));
				return;
			}
		}
	}
}