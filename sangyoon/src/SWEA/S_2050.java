package SWEA;

import java.util.Scanner;

public class S_2050 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String T;
        T=sc.next();

        for(int test_case = 0; test_case < T.length(); test_case++)
        {
            int num = T.charAt(test_case);
            System.out.format("%d ", num - 64);
        }
    }
}
