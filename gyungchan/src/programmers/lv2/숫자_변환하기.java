package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자_변환하기 {

    static int[] ch = new int[1000001];

    public static int solution(int x, int y, int n) {
        int answer = 0;
        if(x==y) return answer;

        ch[x] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int tmp = Q.poll();
                int a = tmp + n;
                int b = tmp * 2;
                int c = tmp * 3;
                if (a == y || b == y || c == y) return answer + 1;
                if (a<y && ch[a] == 0) {
                    ch[a] = 1;
                    Q.offer(a);
                }
                if (b<y && ch[b] == 0) {
                    ch[b] = 1;
                    Q.offer(b);
                }
                if (c<y && ch[c] == 0) {
                    ch[c] = 1;
                    Q.offer(c);
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        int n = 4;
        System.out.println(solution(x, y, n));
    }
}
