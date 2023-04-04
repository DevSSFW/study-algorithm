package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11724 {
    public static int[][] graph;
    public static boolean[] visited;
    public static int node, line, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        graph = new int[node + 1][node + 1];
        visited = new boolean[node + 1];
        count = 0;

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }

        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= node; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
