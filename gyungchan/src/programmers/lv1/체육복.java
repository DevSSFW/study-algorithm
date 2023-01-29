package programmers.lv1;

import java.util.Arrays;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) {
                continue;
            }
            answer--;
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] - 1 == lost[i] || reserve[j] + 1 == lost[i]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {4, 2};
        int[] reserve = {3, 5};

        System.out.println(solution(n, lost, reserve));
    }
}
