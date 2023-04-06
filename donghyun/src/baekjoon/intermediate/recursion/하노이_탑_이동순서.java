package baekjoon.intermediate.recursion;

import java.util.*;

public class 하노이_탑_이동순서 { //장대는 3개, 원판 개수는 n개
    // 원판이 5개 -> 5번 원판은 4개의 원판이 위에 없어야 이동할 수 있다.
    // 원판이 1개면 이동 횟수는 1이다.
    // 원판이 k개면 k-1개가 위에 없어야 이동한다.
    // 원판이 k-1개일때 옮길 수 있으면 k개일 때도 옮길 수 있다. : 귀납적

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println((1 << n) - 1); // 최소 횟수는 2의 n승 -1 (일반항)
        hanoi(1, 3, n);
    }

    public static void hanoi(int a, int b, int n) { //시작 장대와 이동 완료할 장대, 원판 개수
        // ex) 1에서 3으로, n은 3개
        if (n == 1) { //원판 개수 1개면 바로 이동되므로 출력 - base case
            System.out.println(a + " " + b);
            return;
        }
        hanoi(a, 6 - a - b, n - 1); // 장대 3개의 번호 (1+2+3) - a - b
        System.out.println(a + " " + b); // ex 맨 처음은 1 3 출력됨
        hanoi(6 - a - b, b, n - 1);
    }
}
