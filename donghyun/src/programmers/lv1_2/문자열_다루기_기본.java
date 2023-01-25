package programmers.lv1_2;

import java.util.Scanner;

public class 문자열_다루기_기본 {
    public static boolean solution(String s) {
        boolean answer = true;

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            int st = s.charAt(i);
            if (st <= 47 || st >= 58) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
}
