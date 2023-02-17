package baekjoon.intermediate.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * B_1874
 */
public class 스택_수열 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i < T; i++) {

            int number = Integer.parseInt(br.readLine());

            if (number > max) {
                for (int k = max + 1; k <= number; k++) {
                    stack.push(k);
                    sb.append("+").append("\n");
                }
                max = number;

            } else if (stack.peek() != number) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
