package baekjoon.intro.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * B_5598
 */
public class 카이사르_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(decoding(s.charAt(i)));
            System.out.print(arr[i]);
        }
        br.close();
    }

    public static char decoding(char c) {
        if (c == 'A') {
            return 'X';
        } else if (c == 'B') {
            return 'Y';
        } else if (c == 'C') {
            return 'Z';
        }
        return (char) (c - 'Z' + 'W');
    }
}
