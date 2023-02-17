package baekjoon.Intro.string;

import java.io.*;
import java.util.*;

public class 상수 {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");

        n = reverse(Integer.parseInt(num[0]));
        m = reverse(Integer.parseInt(num[1]));

        System.out.println(Math.max(n, m));
    }

    private static int reverse(int i) {
        int answer = 0;
        while (i != 0) { //734
            answer = answer * 10 + i % 10;
            i /= 10;
        }
        return answer;
    }
}
