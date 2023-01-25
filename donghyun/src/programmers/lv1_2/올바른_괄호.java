package programmers.lv1_2;


import java.util.Stack;

public class 올바른_괄호 {
    static boolean answer;
    public static boolean solution(String s) { // (())()()
        Stack<Character> stack = new Stack<>();

        for (int T = 0; T < s.length(); T++) {
            if (s.charAt(T) == '(') {
                stack.push(s.charAt(T));
            } else {
                if (stack.size() == 0) {
                    stack.push(s.charAt(T));
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        answer = stack.isEmpty();
        return answer;
    }
}
