package baekjoon.basic.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Prac {
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World");
        //System.out.println("Hello\nWorld");
        System.out.println("\"!@#$%^&*()\"");
        System.out.println("\"C:\\Download\\hello.cpp\"");

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        //StringBuffer sb2 = new StringBuffer();
        //StringTokenizer st = new StringTokenizer(String.valueOf(""));


        int n = sc.nextInt();
        System.out.println(n);
        int x = Integer.parseInt(br.readLine());
        System.out.println(x);
        br.close();

        char c = sc.next().charAt(0); // charAt() -> String type의 데이터에서 특정 문자를 char type으로 변환
        System.out.println(c);

        float f = sc.nextFloat();
        System.out.printf("%.6f", f); //printf -> 출력 형식 변환문
        /**
         * <p>%b boolean 형식 출력
         * %d 정수 형식
         * %f 소수점
         * %c, %s  문자형식 / 문자열
         * %n 줄바꿈 기능</p>
         */
        char c1 = sc.next().charAt(0);
        char c2 = sc.next().charAt(0);
        System.out.printf("%s %s", c2, c1);

        System.out.println(n + " " + n + " " + n + " ");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d ",n);
        }
    }
}
