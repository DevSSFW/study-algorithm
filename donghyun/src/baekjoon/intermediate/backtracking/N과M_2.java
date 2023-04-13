package baekjoon.intermediate.backtracking;
import java.util.*;

public class N과M_2 {
    static int n, m; // n은 수열의 길이(1부터 n까지), m은 조합할 개수
    static int[] arr; //조합할 숫자를 담는 배열을 생성한다.
    static boolean[] visited; //수열의 요소를 방문 여부로 담을 것이다. (1부터 n까지)
    static StringBuilder sb = new StringBuilder();

    public static void solution(int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (visited[i]) continue; // 사용한 값은 중복되지 않음.
            visited[i] = true; //T,F F -> F,T,F -> F,F,T
            arr[depth] = i; // 1 -> 2 -> 3
            solution(depth + 1, i+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n + 1];
        solution(0, 1);
        System.out.println(sb);
    }
}
