package baekjoon.intermediate.greedy;

import java.util.*;

public class 동전0 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];

        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
        for (int j = N - 1; j >= 0; j--) {
            if (K < arr[j]) continue;
            answer += K / arr[j];
            K %= arr[j];
        }
        System.out.println(answer);
    }
}
