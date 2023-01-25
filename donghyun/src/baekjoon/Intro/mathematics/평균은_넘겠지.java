package baekjoon.Intro.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <p>백준 10871번</p>
 */
public class 평균은_넘겠지 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            int[] testCase = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            double sum = 0;

            for (int j = 1; j < testCase.length; j++) {
                sum += testCase[j];
            }

            double average = sum / testCase[0];
            int count = 0;

            for (int c = 1; c < testCase.length; c++) {
                if (testCase[c] > average) {
                    count++;
                }
            }

            double percentage = ((double) count / testCase[0]) * 100;
            System.out.printf("%.3f%%\n", percentage);
        }
    }
}
