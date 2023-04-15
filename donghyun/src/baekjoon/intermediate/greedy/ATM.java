package baekjoon.intermediate.greedy;

import java.util.*;

public class ATM {
    static int N;
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(greedy(arr));

    }

    private static int greedy(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int add = 0;
        for (int i = 0; i < N; i++) {
            add += arr[i];
            sum += add;
        }
        return sum;
    }
}
