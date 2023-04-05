package baekjoon.intermediate.greedy;

import java.util.*;

public class 곱셈 {
    static long a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.println(pow(a,b,c));

    }
    public static long pow(long a, long b, long c) {
        if (b == 1) return a % c;

        long val = pow(a, b / 2, c);
        if (b % 2 == 0) return val;
        return val * a % c;
    }
}
