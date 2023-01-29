package programmers.lv1;

public class 약수의_개수와_덧셈 {

    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int count = 1; // 자신과 같은 수는 무조건 약수로 포함되므로 1을 저장해둔다.
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if (count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int left = 24;
        int right = 27;
        System.out.println(solution(left, right));
    }
}
