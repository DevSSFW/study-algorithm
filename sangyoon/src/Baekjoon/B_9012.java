package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            String[] VPS = br.readLine().split("");

            int temp = 0;
            for (String vp : VPS) {
                if (temp <= -1) break;
                if (vp.equals("(")) temp++;
                else if (vp.equals(")")) temp--;
            }
            if (temp == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
