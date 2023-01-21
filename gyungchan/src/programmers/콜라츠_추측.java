package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 콜라츠_추측 {
    public static int solution(long num) {
        int answer = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (num * 3) + 1;
            }
            answer++;
            if (answer == 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}
