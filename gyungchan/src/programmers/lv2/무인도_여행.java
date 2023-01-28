package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;

public class 무인도_여행 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int count;

    public static ArrayList<Integer> solution(String[] maps) {
        int x = maps.length;
        int y = maps[0].length();
        map = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char tmp = maps[i].charAt(j);
                if (Character.isDigit(tmp)) {
                    map[i][j] = tmp - '0';
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] != 0) {
                    count = 0;
                    DFS(i, j, x, y);
                    answer.add(count);
                }
            }
        }

        if (answer.size() == 0) {
            answer.add(-1);
        } else {
            Collections.sort(answer);
        }
        return answer;
    }

    private static void DFS(int i, int j, int x, int y) {
        count += map[i][j];
        map[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni >= 0 && nj >= 0 && ni < x && nj < y && map[ni][nj] != 0) {
                DFS(ni, nj, x, y);
            }
        }
    }

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};

        for (int x : solution(maps)) {
            System.out.print(x + " ");
        }
    }
}
