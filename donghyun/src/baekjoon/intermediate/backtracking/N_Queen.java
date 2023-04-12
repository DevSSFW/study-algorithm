package baekjoon.intermediate.backtracking;

import java.util.*;

public class N_Queen {
    private static int N;
    private static int[] map; //2차원 배열로 풀어야 된다고 생각했지만 1차원으로 가능하다.
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N]; //퀸이 놓인 열 값을 나타내는 배열 생성

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            map[depth] = i;
            //depth(행)의 n 만큼 열을 검사, (0,0) ~ (0,7)
            if (isPossible(depth)) { //depth 행에 놓을 수 있으면 다음 행으로 재귀 탐색, 자동으로 같은 행에는 판별 안하도록 하는 로직
                dfs(depth + 1);
            }
        }
    }

    private static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            //대각선 상에 있거나, 같은 열에 퀸이 있는 경우엔
            if (depth - i == Math.abs(map[depth] - map[i]) || map[depth] == map[i]) {
                return false;
            }
        }
        return true;
    }
}
