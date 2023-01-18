package baekjoon.intermediate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * B_9093
 */
public class 단어_뒤집기 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            StringBuilder sb = new StringBuilder();
            String s = br.readLine() + "\n";
            char[] arr = s.toCharArray();

            for (char str : arr) {
                if (str == ' ' || str == '\n') {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                    continue;
                }
                stack.push(str);
            }
            bw.write(sb.toString() + "\n");
            stack.clear();
        }
        bw.flush();
        bw.close();
    }
}
