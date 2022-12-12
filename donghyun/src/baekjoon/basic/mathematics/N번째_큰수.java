package baekjoon.basic.mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class N번째_큰수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[10];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }

            Arrays.sort(arr);
            result[i] = arr[7];
        }
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
