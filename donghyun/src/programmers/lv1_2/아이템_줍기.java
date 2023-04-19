package programmers.lv1_2;

import java.util.*;

public class 아이템_줍기 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int answer;

    //BFS 탐색을 통해서 해결
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 5, 7}};
        int x = 1;
        int y = 1;
        int ix = 4;
        int iy = 7;
        System.out.println(solution(arr, x, y, ix, iy));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] arr : rectangle) {
            fill(arr[0] * 2, arr[1] * 2, arr[2] * 2, arr[3] * 3);
        }
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer / 2;
    }

    public static void fill(int lx, int ly, int rx, int ry) {
        map = new int[101][101];

        for (int i = lx; i <= rx; i++) { // 1~7
            for (int j = ly; j <= ry; j++) { // 1~4
                if (map[i][j] == -1) continue;

                map[i][j] = -1;

                if (i == lx || i == rx || j == ly || j == ry) {
                    map[i][j] = 1;
                }
            }
        }
    }

    public static void bfs(int cx, int cy, int itemX, int itemY) {
        Queue<Point> q = new LinkedList<>();
        answer = 9999;
        visited = new boolean[101][101];
        int[][] dist = new int[101][101];
        q.add(new Point(cx, cy));

        while (!q.isEmpty()) {
            Point p = q.poll();
            int px = p.x;
            int py = p.y;

            if (px == itemX && py == itemY) {
                answer = Math.min(answer, dist[px][py]);
            }
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;

                if (visited[nx][ny] || map[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[px][py] + 1;
                q.add(new Point(nx, ny));
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

