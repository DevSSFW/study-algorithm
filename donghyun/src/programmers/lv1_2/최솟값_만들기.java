package programmers.lv1_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 최솟값_만들기 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        for (int t = 0; t < A.length; t++) {
            answer += A[t] * B[(A.length - 1) - t];
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
    }
}
