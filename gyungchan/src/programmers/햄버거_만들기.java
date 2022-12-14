package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.StandardWatchEventKinds;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 햄버거_만들기 {

    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            int n = stack.size();
            if (n >= 4) {
                if (stack.get(n - 1) == 1 && stack.get(n - 2) == 3
                        && stack.get(n - 3) == 2 && stack.get(n - 4) == 1) {
                    answer++;
                    for (int j = 0; j < 4; j++) stack.pop();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }
}
