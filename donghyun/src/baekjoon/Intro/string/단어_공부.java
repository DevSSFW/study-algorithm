package baekjoon.Intro.string;

import java.io.*;
import java.util.*;

public class 단어_공부 {
    static String strUpper;
    static int max;
    static int[] index;
    static char answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); //Mississipi
        strUpper = str.toUpperCase(); // 대문자로 변환하기

        index = new int[26];
        max = 0;

        for (char c : strUpper.toCharArray()) {
            int temp = ++index[c - 'A']; //전위 연산자
            if (temp > max) {
                max = temp;
                answer = c;
            } else if (temp == max) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
