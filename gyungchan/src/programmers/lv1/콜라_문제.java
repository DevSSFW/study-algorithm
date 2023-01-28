package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 콜라_문제 {

    public static int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int x = (n / a) * b; // 빈병으로 받은 개수
            int y = n % a; // 마트에 가져가고 남은 개수
            n = y + x;
            answer += x;
            System.out.println(answer);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(solution(a, b, n));
    }
}
