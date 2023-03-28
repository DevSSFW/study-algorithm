package baekjoon.intermediate.graph;

import java.util.*;

public class 불 {
    static int R, C;
    static char[][] map;
    static int[][] fireDist;
    static int[][] jDist;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int answer;
    static Queue<Point2> q1 = new LinkedList<>();
    static Queue<Point2> q2 = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        fireDist = new int[R][C]; //불 전파 시간
        jDist = new int[R][C]; // 지훈 이동 시간

        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        // 불, 지훈 배열 -1로 초기화
        for (int i = 0; i < R; i++) {
            Arrays.fill(jDist[i], -1);
            Arrays.fill(fireDist[i], -1);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    q2.add(new Point2(i, j));
                    jDist[i][j] = 0;
                }
                if (map[i][j] == 'F') {
                    q1.add(new Point2(i, j));
                    fireDist[i][j] = 0;
                }
            }
        }
        fBfs();
        jBfs();
    }

    public static void fBfs() {
        while (!q1.isEmpty()) {
            Point2 p1 = q1.poll();
            int px = p1.x;
            int py = p1.y;
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == '#' || fireDist[nx][ny] >= 0) continue;

                fireDist[nx][ny] = fireDist[px][py] + 1;
                q1.add(new Point2(nx, ny));
            }
        }
    }

    public static void jBfs() {
        answer = 0;
        while (!q2.isEmpty()) {
            Point2 p2 = q2.poll();
            int px = p2.x;
            int py = p2.y;
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    answer = jDist[px][py] + 1;
                    System.out.println(answer);
                    return;
                }
                if (map[nx][ny] == '#' || jDist[nx][ny] >= 0) continue;
                // 다음 좌표에 불이 있으면서, 현재 지훈이가 위치한 좌표시간값 +1이 불보다 크거나 같으면 continue;
                if (fireDist[nx][ny] != -1 && jDist[px][py] + 1 >= fireDist[nx][ny]) continue;

                jDist[nx][ny] = jDist[px][py] + 1;
                q2.add(new Point2(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}

class Point2 {
    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}