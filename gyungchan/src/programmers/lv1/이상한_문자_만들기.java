package programmers.lv1;

import java.util.Scanner;

public class 이상한_문자_만들기 {
    public static String solution(String s) {
        String answer = "";
        char[] tmp = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == ' ') idx = -1;
            else if(idx%2==0) tmp[i] = Character.toUpperCase(tmp[i]);
            else tmp[i] = Character.toLowerCase(tmp[i]);
            idx++;
        }

        answer = String.valueOf(tmp);
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        System.out.println(solution(s));
    }
}
