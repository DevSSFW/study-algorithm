package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 0; i < TC; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = 4; j <= N; j++) {
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }

            System.out.println(arr[N]);
        }
    }
}
