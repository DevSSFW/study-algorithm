package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1260 {
    public static int[][] graph;
    public static boolean[] visited;
    public static int NODE, LINE, START;
    public static Queue<Integer> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        NODE = Integer.parseInt(st.nextToken());
        LINE = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());

        graph = new int[NODE + 1][NODE + 1];
        visited = new boolean[NODE + 1];

        for(int i = 0; i < LINE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(START);
        sb.append("\n");
        visited = new boolean[NODE + 1];
        bfs(START);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i <= NODE; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start).append(" ");

            for (int i = 1; i <= NODE; i++) {
                if (graph[start][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
