package programmers;

public class 없는_숫자_더하기 {

    public static int solution(int[] numbers) {
        int answer = 0;
        int[] count = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            count[n]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(solution(numbers));
    }
}
