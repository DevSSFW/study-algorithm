package baekjoon.Intro.string;

import java.io.*;

public class 경고 {
    static String answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split(":");
        String[] end = br.readLine().split(":");

        int hours = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        int second = Integer.parseInt(end[2]) - Integer.parseInt(start[2]);

        if (second < 0) {
            second += 60;
            minute -= 1;
        }
        if (minute < 0) {
            minute += 60;
            hours -= 1;
        }
        if (hours < 0) {
            hours += 24;
        }
        if (hours == 0 && minute == 0 && second == 0) {
            answer = "24:00:00";
        } else {
            answer = String.format("%02d:%02d:%02d", hours, minute, second);
        }
        System.out.println(answer);
    }
}
