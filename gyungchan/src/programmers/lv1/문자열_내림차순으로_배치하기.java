package programmers.lv1;

import java.util.Arrays;

public class 문자열_내림차순으로_배치하기 {
    public static String solution(String s) {
        String answer = "";
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        answer = new StringBuilder(String.valueOf(tmp)).reverse().toString();
        return answer;
    }

    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }
}
