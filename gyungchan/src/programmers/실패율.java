package programmers;

import java.util.Arrays;

public class 실패율 {

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] stage_stop = new int[N+2];
        int[] stage_clear = new int[N+2];
        double[] check = new double[N+1];

        for (int stage : stages) {
            stage_stop[stage]++;
        }

        int sum = 0;
        for (int i = stage_clear.length - 1; i >= 1; i--) {
            sum += stage_stop[i];
            stage_clear[i] = sum;
        }

        for (int i = 1; i <= N; i++) {
            if (stage_clear[i] == 0) {
                check[i] = 0;
            }
            else check[i] = (double) stage_stop[i] / stage_clear[i];
        }

        double[] tmp = check.clone();
        Arrays.sort(check);
        int lt = 0;
        for (int i = check.length - 1; i >= 1; i--) {
            double n = check[i];
            for (int j = 1; j < tmp.length; j++) {
                if (n == tmp[j]) {
                    answer[lt++] = j;
                    tmp[j] = 2;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int N = 4;
        int[] stages = {4,4,4,4,4};

        for (int x : solution(N, stages)) {
            System.out.print(x + " ");
        }
    }
}
