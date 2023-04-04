package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2606 {
    public static int[][] graph;
    public static boolean[] visited;
    public static int count = 0, computer, line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        graph = new int[computer + 1][computer + 1];
        visited = new boolean[computer + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int start) {
        visited[start] = true;
        count++;

        for (int i = 0; i <= computer; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
