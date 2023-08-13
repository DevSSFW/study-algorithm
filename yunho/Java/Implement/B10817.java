package Practice;

import java.util.Scanner;

public class B10817 { //¼¼ ¼ö
    public static void main(String ar[]) {
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        
        int result = a > b ? (a > c ? (b > c ? b : c) : a) : (b > c ? (a > c ? a : c) : b);
        
        System.out.println(result);
    }
}