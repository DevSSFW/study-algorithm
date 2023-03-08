package baekjoon.intermediate.graph;

import java.io.*;
import java.util.*;

public class 그림 {
    static int N, M;
    static int[][] picture;
    static boolean[][] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int digits;
    static int area;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        picture = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        digits = 0;
        area = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (picture[i][j] == 0 || visited[i][j]) {
                    continue;
                }
            }
        }

        // 첫째줄 n,m 행 열 주어지고
        // 둘째줄 그림 정보 0과 1로
        // Output : 그림 개수와 가장 넓은 그릠 넓이

    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        digits++;
    }
}
