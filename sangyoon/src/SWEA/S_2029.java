package SWEA;

import java.io.IOException;
import java.util.Scanner;

public class S_2029 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.format("#%d %d %d\n", test_case, a / b, a % b);
        }
    }
}
