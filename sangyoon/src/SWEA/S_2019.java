package SWEA;

import java.util.Scanner;

public class S_2019 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int a = 1;
        System.out.print(a + " ");

        for(int i = 1; i <= T; i++)
        {
            a *= 2;
            System.out.print(a + " ");
        }
    }
}
