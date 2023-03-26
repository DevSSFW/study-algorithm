package baekjoon.intermediate.graph;

import java.util.*;
public class 미로_탐색 {
    private static int N, M;
    private static int[][] map;
    private static int[][] dist;
    private static final int[] dx = new int[]{-1, 0, 1, 0};
    private static final int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[102][102];
        dist = new int[102][102];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                int number = str.charAt(j) - '0';
                map[i][j] = number;
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;
        bfs(0, 0);
        System.out.println(dist[N-1][M-1]+1);
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int px = p.x;
            int py = p.y;

            for (int i = 0; i < 4; i++) {

                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] != 1 || dist[nx][ny] >= 0) continue;

                dist[nx][ny] = dist[px][py] + 1;
                q.add(new Point(nx, ny));
            }
        }
    }
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
