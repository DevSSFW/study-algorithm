package baekjoon.intermediate.graph;

import java.util.*;

public class 숨바꼭질 {
    static int N, M;
    static int[] map = new int[100001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //수빈이
        M = sc.nextInt(); //동생

        bfs();
        System.out.println(map[M]);

    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N); //ex - 7
        while (!q.isEmpty()) {
            N = q.poll();
            if (N == M) break;

            if (N - 1 >= 0 && map[N - 1] == 0) {
                q.add(N - 1);
                map[N - 1] = map[N] + 1;
            }
            if (N + 1 <= 100000 && map[N + 1] == 0) {
                q.add(N + 1);
                map[N + 1] = map[N] + 1;

            }
            if (N * 2 <= 100000 && map[N * 2] == 0) {
                q.add(2 * N);
                map[N * 2] = map[N] + 1;
            }
        }
        //x+1, x-1, 2*x
    }
}
