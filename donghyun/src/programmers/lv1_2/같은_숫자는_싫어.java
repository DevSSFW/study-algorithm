package programmers.lv1_2;

import java.util.*;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(solution(arr));
    }

    public static Stack<Integer> solution(int[] arr) {
        Stack<Integer> answer = new Stack<>();
        answer.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (answer.peek() == arr[i]) continue;
            answer.push(arr[i]);
        }
        return answer;
    }
}
