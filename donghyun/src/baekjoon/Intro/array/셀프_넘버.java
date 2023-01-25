package baekjoon.Intro.array;

import java.io.IOException;

/**
 * <p>B_4673</p>
 * 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수로 정의
 * ex) 33 -> 33+3+9=39 -> 39+3+9=51, ...
 * 셀프 넘버 : 생성자가 없는 숫자
 */
public class 셀프_넘버 {
    public static final int MAX = 10001;

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] selfNumber = new boolean[MAX];

        for (int i = 1; i < MAX; i++) {
            int n = selfNumbering(i);

            if (n < MAX) {
                selfNumber[n] = true;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < MAX; i++) {
            if (!selfNumber[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int selfNumbering(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
