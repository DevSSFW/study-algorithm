package programmers;

public class 삼진법_뒤집기 {

    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n = n / 3;
        }

        answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }
}
