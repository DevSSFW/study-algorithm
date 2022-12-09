package baekjoon.basic.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * <p>%b boolean 형식 출력
 * %d 정수 형식
 * %f 소수점
 * %c, %s  문자형식 / 문자열
 * %n 줄바꿈 기능</p>
 */
public class Prac {
    public static void main(String[] args) throws IOException { //정규 표현식

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringTokenizer st = new StringTokenizer(s, ":");
        String[] arr = new String[2];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }
        if (Objects.equals(arr[1], "00")) {
            System.out.println("0");
        } else {
            System.out.println(arr[1]);
        }


        /*
        String[] arr1 = s.split("\\.");
        System.out.println(arr1[0] + "\n" + arr1[1]);

        String[] arr = sc.next().split("[.]");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        System.out.printf("%d\n%d", x, y);

         */
    }
}
        /*
        Scanner sc = new Scanner(System.in);
        boolean b = sc.nextBoolean();
        String s = sc.nextLine();
        System.out.println();
        StringTokenizer st = new StringTokenizer(s,".");
        st.nextToken();
         */
/**
 * O(1) – 상수 시간 : 문제를 해결하는데 오직 한 단계만 처리함.
 * O(log n) – 로그 시간 : 문제를 해결하는데 필요한 단계들이 연산마다 특정 요인에 의해 줄어듬.
 * O(n) – 직선적 시간 : 문제를 해결하기 위한 단계의 수와 입력값 n이 1:1 관계를 가짐.
 * O(n log n) : 문제를 해결하기 위한 단계의 수가 N*(log2N) 번만큼의 수행시간을 가진다. (선형 로그형 )
 * O(n^2) – 2차 시간 : 문제를 해결하기 위한 단계의 수는 입력값 n의 제곱.
 * O(C^n) – 지수 시간 : 문제를 해결하기 위한 단계의 수는 주어진 상수값 C 의 n 제곱.
 */
