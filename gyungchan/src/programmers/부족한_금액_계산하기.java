package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부족한_금액_계산하기 {

    public static long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }
        if (sum > money) {
            answer = sum - money;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        System.out.println(solution(price, money, count));
    }
}
