package programmers.lv1;

public class 짝수와_홀수 {
    public static String solution(int num) {
        String answer = "Odd";
        if (num % 2 == 0) {
            answer = "Even";
        }

        return answer;
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println(solution(num));
    }
}
