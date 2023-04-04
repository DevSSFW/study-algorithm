package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2667 {
    static int N;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int apart[];
    static int number = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        apart = new int[N * N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    number++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(apart);
        System.out.println(number);

        for (int j : apart) {
            if (j != 0) System.out.println(j);
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        apart[number]++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
