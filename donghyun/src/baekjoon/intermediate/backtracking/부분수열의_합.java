package baekjoon.intermediate.backtracking;

import java.util.*;

public class 부분수열의_합 {
    static int n, s;
    static int[] arr;
    static int counter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int temp = 0;
        solution(0, 0);
        counter = s == 0 ? counter - 1 : counter; //공집합 제거 요소
        System.out.println(counter);
    }

    private static void solution(int start, int temp) {
        if (start == n) {
            if (temp == s) {
                counter++;
            }
            return;
        }
        //현재 원소를 선택한 경우
        solution(start + 1, temp + arr[start]);
        //현재 원소를 선택하지 않은 경우
        solution(start + 1, temp);
    }
}
