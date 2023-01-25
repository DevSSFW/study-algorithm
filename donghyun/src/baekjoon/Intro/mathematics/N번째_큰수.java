package baekjoon.Intro.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p>백준 2693번 문제</p>
 */
public class N번째_큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int index = 0; index < N; index++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];

            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            System.out.println(arr[7]);
        }
        /*Scanner sc = new Scanner(System.in);
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
        }*/
    }
}
