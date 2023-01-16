package baekjoon.intermediate;

import java.io.*;
import java.util.Stack;

/**
 * B_9012
 */
public class 괄호 {
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static String decodeVPS(String s, Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    stack.push(c);
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            sb.append(YES);
        } else {
            sb.append(NO);
        }
        stack.clear();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            String s = br.readLine();

            bw.write(decodeVPS(s, stack) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
