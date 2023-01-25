package baekjoon.Intro.mathematics;

import java.io.*;

public class 이진수 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; n >= 1 << j; j++) {
                if ((n & (1 << j)) >= 1) {
                    bw.write(j + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
