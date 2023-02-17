package baekjoon.intermediate.data_structure;

import java.io.*;
import java.util.Stack;

/**
 * B_10773
 */
public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                answer -= stack.pop();
                continue;
            }
            answer += stack.push(number);
        }
        System.out.println(answer);
    }
}
