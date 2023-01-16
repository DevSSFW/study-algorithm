package programmers;

public class x만큼_간격이_있는_n개의_숫자 {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;
    }

    public static void main(String[] args) {
        int x = 4;
        int n = 3;

        for (long num : solution(x, n)) {
            System.out.print(num + " ");
        }
    }
}
