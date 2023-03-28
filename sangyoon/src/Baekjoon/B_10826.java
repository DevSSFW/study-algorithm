package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B_10826 {
    static BigInteger[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new BigInteger[N + 2];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;

        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i - 2].add(arr[i - 1]);
        }

        System.out.println(arr[N]);
    }
}
