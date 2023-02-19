package baekjoon.Intro.string;

import java.io.*;
import java.util.Arrays;

public class 창영_마을 {
    static int answer;
    static String[] location = {"1", "0", "0"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split("");
        answer = changeBall(arr);
        System.out.println(answer);
    }

    private static int changeBall(String[] arr) {
        for (String s : arr) {
            switch (s) {
                case "A": {
                    String temp = location[1];
                    location[1] = location[0];
                    location[0] = temp;
                    break;
                }
                case "B": {
                    String temp = location[2];
                    location[2] = location[1];
                    location[1] = temp;
                    break;
                }
                case "C": {
                    String temp = location[2];
                    location[2] = location[0];
                    location[0] = temp;
                    break;
                }
            }
        }
        return Arrays.asList(location).indexOf("1") + 1;
    }
}
