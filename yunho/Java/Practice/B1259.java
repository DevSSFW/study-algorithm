package Practice;

import java.util.Scanner;

public class B1259 { //ÆÓ¸°µå·Ò¼ö

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		 String s = "";
		 int size;
		 
		 while((s = sc.next()) != null) {
			 size = s.length();
			 boolean isEqual = true;
			 
			 if(s.charAt(0) == '0') break;
			 for(int i = 0; i <= size / 2; i++) {
				 char c1 = s.charAt(i);
				 char c2 = s.charAt(size - i - 1);
				 if(c1 != c2) {
					 isEqual = false;
					 System.out.println("no");
					 break;
				 }
			 }
			 
			 if(isEqual) System.out.println("yes");
		 }
	}
}
