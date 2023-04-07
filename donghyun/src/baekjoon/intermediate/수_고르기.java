package baekjoon.intermediate;

import java.util.*;

public class 수_고르기 {
    static int N, M;
    static int[] arr;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(twoPointer());
    }

    public static int twoPointer() {
        int start = 0;
        int end = 0;

        while (start <= end && end < N) {
            if (arr[end] - arr[start] >= M) { //start++ 조건
                min = Math.min(min, arr[end] - arr[start]);
                start++;
            } else end++;
        }


        return min;
    }
}

