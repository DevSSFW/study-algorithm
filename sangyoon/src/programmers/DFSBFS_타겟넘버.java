package programmers;

import java.io.IOException;

public class DFSBFS_타겟넘버 {
    public static void main(String[] args) throws IOException {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        DFSBFS_타겟넘버 s = new DFSBFS_타겟넘버();
        System.out.println(s.solution(numbers, target));
    }

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }

    //DFS
    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}
