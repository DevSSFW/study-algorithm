package baekjoon.intermediate.graph;

import java.util.*;

public class 토마토 {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //열 개수
        N = sc.nextInt(); //행 개수

        map = new int[1002][1002]; // N x M으로 수정 6,4
        dist = new int[1002][1002]; // N x M으로 수정 6,4

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    dist[i][j] = -1;
                }
                if (map[i][j] == 1) {
                    q.add(new Point(i, j));
                }
            }
        }


        bfs();
        System.out.println(solution());
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            int px = p.x;
            int py = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[px][py] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static int solution() {
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1) {
                    return -1; //토마토가 모두 익지 못한 상황
                }
                answer = Math.max(answer, dist[i][j]);
            }
        }
        return answer; //거리 반환
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
