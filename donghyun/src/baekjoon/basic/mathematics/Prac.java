package baekjoon.basic.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(1);
        } else
            System.out.println(0);

        br.close();
    }
}
/**
 * <p>B_1000</p>
 * int sum = 0;
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 * <p>
 * for (int i = 0; i < 2; i++) {
 * int number = Integer.parseInt(st.nextToken());
 * sum += number;
 * }
 * <p>
 * System.out.println(sum);
 * br.close();
 * <p>
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 * <p>
 * int[] arr = new int[3];
 * for (int i = 0; i < arr.length; i++) {
 * arr[i] = Integer.parseInt(st.nextToken());
 * }
 * Arrays.sort(arr);
 * System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
 * <p>
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 * <p>
 * int[] arr = new int[3];
 * for (int i = 0; i < arr.length; i++) {
 * arr[i] = Integer.parseInt(st.nextToken());
 * }
 * Arrays.sort(arr);
 * System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
 */

/**
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 *
 *         int[] arr = new int[3];
 *         for (int i = 0; i < arr.length; i++) {
 *             arr[i] = Integer.parseInt(st.nextToken());
 *         }
 *         Arrays.sort(arr);
 *         System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
 */
