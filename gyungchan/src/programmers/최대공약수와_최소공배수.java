package programmers;

public class 최대공약수와_최소공배수 {
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        for (int i = 1; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                answer[0] = i;
            }
        }
        int i = 1;
        while (true) {
            int x = max * i;
            if (x % min == 0) {
                answer[1] = x;
                break;
            }
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        for (int x : solution(n, m)) {
            System.out.print(x + " ");
        }
    }
}
