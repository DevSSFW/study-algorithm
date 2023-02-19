package baekjoon.Intro.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 복호화 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] arr = new int[26];
            int max = 0;
            int count = 0;
            int answer = 0;

            String s = br.readLine();

            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) >= 'a' && s.charAt(k) <= 'z') {
                    arr[s.charAt(k) - 'a']++;
                }
            }
            for (int r : arr) {
                if (max < r) {
                    max = r;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == max) {
                    count++;
                    answer = j;
                }
            }
            if (count == 1) {
                System.out.println((char) ('a' + answer));
            } else {
                System.out.println("?");
            }
        }
    }
}
