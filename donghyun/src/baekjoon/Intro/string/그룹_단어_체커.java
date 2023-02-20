package baekjoon.Intro.string;

import java.io.*;

public class 그룹_단어_체커 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (checkGroup()) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean checkGroup() throws Exception {
        boolean[] word = new boolean[26];
        int previous = 0;
        String sentence = br.readLine();

        for (int j = 0; j < sentence.length(); j++) {
            int now = sentence.charAt(j);

            if (now != previous) {
                if (!word[now - 'a']) {
                    word[now - 'a'] = true;
                    previous = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
