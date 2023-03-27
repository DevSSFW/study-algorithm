package programmers;

import java.io.IOException;

public class 문자열_문자열나누기 {
    public static void main(String[] args) throws IOException {
        String string = "banana";

        문자열_문자열나누기 s = new 문자열_문자열나누기();
        System.out.println(s.solution(string));
    }

    public String solution(String s) {
        char first = s.charAt(0);
        int firstNum = 0;
        int diffNum = 0;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if(firstNum == diffNum) {
                answer++;
                first = s.charAt(i);
            }
            if(s.charAt(i) == first) firstNum++;
            else diffNum++;
        }

        return String.valueOf(answer);
    }
}
