package baekjoon.Intro.string;

import java.io.*;

public class 아스키_코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = br.readLine().charAt(0);

        System.out.println((int) c);
    }
}
