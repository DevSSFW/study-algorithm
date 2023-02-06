package programmers.lv1;

import java.util.Scanner;

public class 자릿수_더하기 {
    public static int solution(int n) {
        int answer = 0;
        while (n > 0) {
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(solution(n));
    }
}
