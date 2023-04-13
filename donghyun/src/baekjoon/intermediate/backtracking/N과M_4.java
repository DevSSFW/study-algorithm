package baekjoon.intermediate.backtracking;

import java.util.Scanner;

public class N과M_4 {
    //비내림차순
    static int n, m;
    static int[] arr;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m]; // 순서쌍 배열
        checked = new boolean[n + 1]; // 1,2,3 ... 사용여부
        dfs(0,1);
        System.out.print(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            checked[i] = true; // 1 -> true
            arr[depth] = i; // (1, -) -> (1,1) -> (1,2) -> ... ->(2,1)
            dfs(depth + 1, i);
            /**
             * checked 배열에서 조건문으로 i+1을 비교해서 알아내는 로직인줄 알았으나
             * start 값을 i로 주면 간단하다. (비내림차순)
             */
            checked[i] = false;
        }

    }
}
