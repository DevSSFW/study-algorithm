import java.util.*;

public class FrogJump {
    int answer,tmp = 0;

    public int solution(int X, int Y, int D) {
        while (true) {
            if (tmp >= Y) {
                break;
            } else {
                tmp += X + D;
                answer++;
            }
        }
        return answer;
    }
}
/**
 * Time Complexity : 11%
 * 개선 방안 -> while문 대신 함수적 풀이 접근
 *
 */
