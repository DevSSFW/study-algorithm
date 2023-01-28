package programmers.lv1;

public class 하샤드_수 {
    public static boolean solution(int x) {
        boolean answer = true;
        int sum = getSumDigits(x);

        if (x % sum != 0) {
            answer = false;
        }

        return answer;
    }

    private static int getSumDigits(int tmp) {
        int sum = 0;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp = tmp / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr = 11;

        System.out.println(solution(arr));
    }
}
