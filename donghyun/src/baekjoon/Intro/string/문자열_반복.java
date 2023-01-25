package baekjoon.Intro.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String result = "";
            String[] arr = br.readLine().split(" ");
            int count = Integer.parseInt(arr[0]);

            for (int j = 0; j < arr[1].length(); j++) {
                for (int k = 0; k < count; k++) {
                    result += arr[1].charAt(j);
                }
            }
            System.out.println(result);
        }
    }
}
