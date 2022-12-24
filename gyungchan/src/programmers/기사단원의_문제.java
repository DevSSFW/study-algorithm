package programmers;

import java.io.IOException;

public class 기사단원의_문제 {
    public static int solution(int number, int limit, int power) {
        int answer = 1; //1인 경우 무조건 약수가 1이므로 1의 약수값을 먼저 넣어준다.
        for (int i = 2; i <= number; i++) {
            //모든 수는 1과 자신과 같은 수를 약수로 가지므로 count 값을 2로 저장한다.
            int count = 2;
            //어떤 수든 자신의 중간값보다 더 큰 수가 약수로 나올수 없으므로 j는 i/2의 값까지만 반복한다.
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int number = 10;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number, limit, power));
    }
}
