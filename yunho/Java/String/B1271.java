package Practice;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1271 { //엄청난 부자2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str);
	
		BigInteger N = new BigInteger(st.nextToken());
		BigInteger M = new BigInteger(st.nextToken());
	
		System.out.println((N.divide(M)) + "\n" + (N.mod(M)));
	}
}