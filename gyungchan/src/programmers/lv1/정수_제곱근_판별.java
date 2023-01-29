package programmers.lv1;

public class 정수_제곱근_판별 {
    public static long solution(long n) {
        if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }
        return -1;
    }

    public static void main(String[] args) {
        long n = 3;
        System.out.println(solution(n));
    }
}
