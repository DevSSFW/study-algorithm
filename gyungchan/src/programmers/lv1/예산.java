package programmers.lv1;

import java.util.Arrays;

public class 예산 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int price : d) {
            if (budget - price >= 0) {
                answer++;
                budget = budget - price;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;

        System.out.println(solution(d, budget));
    }
}
