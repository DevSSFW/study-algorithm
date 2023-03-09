package baekjoon.intermediate.graph;

import java.io.*;
import java.util.*;

public class 그림 {
    static int N, M;
    static int[][] picture;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (picture[i][j] == 0 || visited[i][j]) continue; //그림이 아니거나, 방문했을 경우
                area = Math.max(area, bfs(i, j));
                digits++;
            }
        }
        System.out.println(digits);
        System.out.println(area);

        // 첫째줄 n,m 행 열 주어지고
        // 둘째줄 그림 정보 0과 1로
        // Output : 그림 개수와 가장 넓은 그릠 넓이
    }

    public static int bfs(int x, int y) {
        visited[x][y] = true; // 방문 표시
        q.offer(new int[]{x, y}); //방문 좌표 큐에 넣음
        area = 0;
        while (!q.isEmpty()) { //큐가 비어있을 때 까지
            area++; //넓이 1씩 증가 = 넓이
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            for (int n = 0; n < 4; n++) { //상하좌우 탐색
                int nx = px + dx[n];
                int ny = py + dy[n];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 좌표의 행과 열 값이 그림 범위 밖일 경우
                if (visited[nx][ny] || picture[nx][ny] == 0) continue; // 방문했거나 그림이 아닐 경우
                visited[nx][ny] = true; //다음 좌표 방문
                q.offer(new int[]{nx, ny}); // 다음 좌표 큐에 넣고 빌 때까지 반복
            }
        }
        return area;
    }
}
