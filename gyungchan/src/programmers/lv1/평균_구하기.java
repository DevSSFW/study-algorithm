package programmers.lv1;

import java.util.Arrays;

public class 평균_구하기 {
    public static double solution(int[] arr) {
        double answer = (double) Arrays.stream(arr).sum() / arr.length;

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        System.out.println(solution(arr));
    }
}
