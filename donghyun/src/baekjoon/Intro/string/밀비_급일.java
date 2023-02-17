package baekjoon.Intro.string;

import java.io.*;

public class 밀비_급일 {
    static final String END = "END";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals(END)) {
                break;
            }
            StringBuilder reverse = new StringBuilder(input);
            reverse.reverse(); //StringBuilder의 reverse() 메소드 이용하기
            answer.append(reverse).append("\n");
        }
        System.out.println(answer);
    }
}
