package baekjoon.intermediate.backtracking;

import java.util.*;

/**
 * N과 M_3
 * 1부터 N까지 자연수 중 M개를 고른다.
 * 같은 수를 여러번 골라도 된다. 1,1 1,2,1,3 2,1 2,2
 */
public class N과M_3 {
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
        dfs(0, 1);
        System.out.print(sb);
    }

    private static void dfs(int depth, int start) { // 0, 1
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            checked[i] = true; // 1 -> true
            arr[depth] = i; // (1, -) -> (1,1)
            dfs(depth + 1, start);
            checked[i] = false;
        }
    }
}
