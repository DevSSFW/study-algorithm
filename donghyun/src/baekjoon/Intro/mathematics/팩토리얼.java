package baekjoon.Intro.mathematics;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
    //재귀 함수 활용하기
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else
            return n * factorial(n - 1);
    }
}
