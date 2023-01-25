package programmers.lv1_2;

import java.util.Arrays;

/**
 * int[] d , int budget
 */
public class 예산 {
    public static int solution(int[] d, int budget) {
        Arrays.sort(d); //오름차순으로 정렬
        int answer = 0;

        for (int t = 0; t < d.length; t++) {
            if (budget >= d[t]) {
                budget -= d[t];
                answer++;
            }
        }
        return answer;
    }
}
