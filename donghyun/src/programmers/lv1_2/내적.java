package programmers.lv1_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 내적 {
    static int answer = 0;

    public static int solution(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
