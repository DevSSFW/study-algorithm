package baekjoon.intermediate.greedy;

import java.util.*;
import java.io.*;

public class 삼십 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 입력받은 문자열을 문자 배열로 변환
        char[] digits = str.toCharArray();

        // 자리수의 합을 구하기 위해 각 자리 숫자를 더함
        int sum = 0;
        for (char digit : digits) {
            sum += digit - '0';
        }

        // 입력된 숫자들이 0을 포함하고, 자리수의 합이 3의 배수인지 확인
        if (!str.contains("0") || sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        // 내림차순으로 정렬하여 가장 큰 수를 만듦
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder();
        for (char digit : digits) {
            sb.append(digit);
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
