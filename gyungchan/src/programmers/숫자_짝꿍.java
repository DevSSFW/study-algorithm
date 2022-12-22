package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자_짝꿍 {

    public static String solution(String X, String Y) {
        String answer = "";
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        int x_lt = 0;
        int y_lt = 0;
        StringBuilder sb = new StringBuilder();
        while (x_lt < x.length && y_lt < y.length) {
            if (x[x_lt] == y[y_lt]) {
                sb.append(x[x_lt]);
                x_lt++;
                y_lt++;
            } else if (x[x_lt] > y[y_lt]) {
                y_lt++;
            } else {
                x_lt++;
            }
        }
        answer = sb.reverse().toString();
        if (answer.length() < 1) return "-1";
        if (answer.charAt(0) == '0') return "0";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        String Y = br.readLine();

        System.out.println(solution(X, Y));
    }
}
