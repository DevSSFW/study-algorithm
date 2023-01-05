package baekjoon.basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String[] arr = s.split("");
        int sum = 0;
        for (int test_case = 0; test_case < arr.length; test_case++) {
            sum += Integer.parseInt(arr[test_case]);
        }
        System.out.println(sum);
    }
}
