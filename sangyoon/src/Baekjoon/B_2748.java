package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = 1;
        long f1 = 0;
        long f2 = 1;
        for (int i = 1; i < n; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }

        System.out.println(sum);
    }
}
