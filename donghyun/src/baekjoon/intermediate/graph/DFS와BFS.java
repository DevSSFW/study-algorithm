package baekjoon.intermediate.graph;

import java.io.*;
import java.util.*;

public class DFS와BFS {
    static StringBuilder sb = new StringBuilder();
    static int node, line, start;
    static int[][] lineArr;
    static boolean[] check;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken()); //4
        line = Integer.parseInt(st.nextToken()); //5
        start = Integer.parseInt(st.nextToken()); //1

        lineArr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            lineArr[a][b] = lineArr[b][a] = 1;

        }
        dfs(start);
        sb.append("\n");
        check = new boolean[node + 1];
        bfs(start);
        System.out.println(sb);
        //return sb;


    }
    public static void dfs(int start) { //1
        check[start] = true;
        sb.append(start).append(" ");
        for (int i = 0; i <= node; i++) {
            if (lineArr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }

    }

    public static void bfs(int start) { //1
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");
            for (int i = 1; i <= node; i++) {
                if (lineArr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}

