package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4344 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            double sum = 0;

            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            double avg = sum / n;
            double cnt = 0;

            for(int j = 0; j < n; j++) {
                if(arr[j] > avg) {
                    cnt++;
                }
            }

            double val = (cnt / n) * 100;

            System.out.printf("%.3f%%\n", val);
        }
    }
}
