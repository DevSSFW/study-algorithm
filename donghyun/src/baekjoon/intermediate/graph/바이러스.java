package baekjoon.intermediate.graph;

import java.io.*;
import java.util.*;

public class 바이러스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int computer, line;
    static int answer = 0;
    static int[][] lineArr;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        computer = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        lineArr = new int[computer + 1][computer + 1];
        check = new boolean[computer + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            lineArr[a][b] = lineArr[b][a] = 1;
        }

        dfs(1);
        System.out.println(answer - 1);

    }

    public static void dfs(int start) {
        check[start] = true;
        answer++;

        for (int j = 0; j <= computer; j++) {
            if (lineArr[start][j] == 1 && !check[j]) {
                dfs(j);
            }
        }
        //dfs를 모두 실행 -> dfs(1)로 백트래킹 -> for문 종료

    }

}
