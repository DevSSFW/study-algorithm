package baekjoon.Intro.brute_force;

import java.io.*;
import java.util.*;

public class 블랙잭 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ea;
    static int max;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        ea = Integer.parseInt(input[0]);
        max = Integer.parseInt(input[1]);

        String s = br.readLine();
        int[] cards = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solve(cards));

    }

    private static int solve(int[] cards) {
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < ea; i++) {
            for (int j = i + 1; j < ea; j++) {
                for (int k = j + 1; k < ea; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if (answer < sum && sum <= max) {
                        answer = sum;
                    }
                }
            }
        }
        return answer;
    }
}
