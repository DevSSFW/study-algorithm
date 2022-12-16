package baekjoon.basic.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 대표값2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int amount = 0;
        int middle = 0;
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        amount = sum / 5;
        middle = arr[2];

        System.out.println(amount);
        System.out.println(middle);
    }
}
