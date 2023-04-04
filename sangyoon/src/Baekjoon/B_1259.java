package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String n = br.readLine();
            boolean chk = true;
            if (n.equals("0")) break;

            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) != n.charAt(n.length() - 1 - i)) {
                    chk = false;
                    break;
                }
            }

            if (chk) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
