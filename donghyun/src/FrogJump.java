import java.util.*;

public class FrogJump {
    public static void main(String[] args) {
        int result;
        result = solution(10, 85, 30);
        System.out.printf("result = %d, pass = %b\n", result, result == 3);
    }

    public static int solution(int X, int Y, int D) {


        /**
         * solution 1 : 수학적 접근
         */
        /*
        if (X == Y) // X가 Y랑 같다면
            return 0; // 0 반환

        int jumps = (Y - X) / D; // (길이 - 시작) / 점프
        if (jumps * D + X < Y)
            return jumps + 1;

        return jumps;
        */
        return (int) Math.ceil((double) (Y - X) / D);
        // ceil : 주어진 값 같거나 큰 정수중 최대값
    }
}
/**
 * Time Complexity : 11%
 * 개선 방안 -> while문 대신 함수적 풀이 접근
 */
