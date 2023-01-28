package programmers.lv1;

public class 자연수_뒤집어_배열로_만들기 {
    public static int[] solution(long n) {
        int[] answer = {};
        String[] str = String.valueOf(n).split("");
        answer = new int[str.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(str[str.length - 1 - i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 12345;
        for (int x : solution(n)) {
            System.out.print(x + " ");
        }
    }
}
