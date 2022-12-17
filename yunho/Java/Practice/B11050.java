package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11050 { //이항 계수 1

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		double k = Double.parseDouble(st.nextToken());
		
		if(k < 0) System.out.println(0);
		else if(k > n) System.out.println(0);
		else System.out.println((int)(Fact(n)/(Fact(k)*Fact(n - k))));
	}
	
	public static double Fact(double n) {
		if(n == 1 || n == 0) return 1;
		return n * Fact(n - 1);
	}
}
