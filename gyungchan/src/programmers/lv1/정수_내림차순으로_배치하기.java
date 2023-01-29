package programmers.lv1;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {
    public static long solution(long n) {
        long answer = 0;
        char[] tmp = String.valueOf(n).toCharArray();
        Arrays.sort(tmp);
        String str = "";
        for (int i = 0; i < tmp.length; i++) {
            str += tmp[tmp.length - 1 - i];
        }

        answer = Long.parseLong(str);
        return answer;
    }

    public static void main(String[] args) {
        long n = 118372;
        System.out.println(solution(n));
    }
}
