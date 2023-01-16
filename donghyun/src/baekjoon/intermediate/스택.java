package baekjoon.intermediate;

import java.io.*;
import java.util.Stack;

/**
 * B_10828
 */
public class 스택 {
    static final int ZERO = 0;
    static final int ONE = 1;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> s = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int T = 0; T < N; T++) {
            arr = br.readLine().split(" ");

            switch (arr[ZERO]) {
                case "push":
                    s.push(arr[ONE]);

                    break;
                case "pop":
                    bw.write(s.isEmpty() ? "-1" + "\n" : s.pop() + "\n");

                    break;
                case "size":
                    bw.write(s.size() + "\n");

                    break;
                case "empty":
                    bw.write(s.isEmpty() ? "1" + "\n" : "0" + "\n");

                    break;
                case "top":
                    bw.write(s.isEmpty() ? "-1" + "\n" : s.peek() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
