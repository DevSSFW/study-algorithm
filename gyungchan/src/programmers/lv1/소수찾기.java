package programmers.lv1;

public class 소수찾기 {
    public static int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;

                for (int j = 1; j <= n; j++) {
                    if(i*j > n) break;
                    ch[i * j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }
}
