package baekjoon.intro.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * B_2577
 */
public class 숫자의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int multiply = 1;

        for (int i = 0; i < 3; i++) {
            multiply *= Integer.parseInt(br.readLine());
        }

        int[] counter = new int[10];

        while (multiply > 0) {
            counter[multiply % 10]++;
            multiply /= 10;
        }
        for (int j = 0; j < counter.length; j++) {
            System.out.println(counter[j]);
        }
        br.close();
    }
}