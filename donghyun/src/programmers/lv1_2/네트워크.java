package programmers.lv1_2;

public class 네트워크 {
    public static void main(String[] args) {
        int[][] c = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = solution(3, c);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] computers) {
        int counter = 0;
        boolean[] visit = new boolean[n]; //3대 컴퓨터 방문 배열

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(visit, computers, i);
                counter++;
            }
        }
        return counter;
    }

    public static void dfs(boolean[] visit, int[][] computers, int start) {
        visit[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (start == i) continue;

            if (!visit[i] && computers[start][i] == 1) {
                dfs(visit, computers, i);
            }
        }
    }
}
