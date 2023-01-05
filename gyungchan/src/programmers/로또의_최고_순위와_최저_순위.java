package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로또의_최고_순위와_최저_순위 {

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int count = 0;
        int zero_count = 0;
        int lot_lt = 0;
        int win_lt = 0;
        while (lot_lt < 6 && win_lt < 6) {
            if (lottos[lot_lt] == win_nums[win_lt]) {
                count++;
                lot_lt++;
                win_lt++;
            } else if (lottos[lot_lt] < win_nums[win_lt]) {
                if (lottos[lot_lt] == 0) {
                    zero_count++;
                }
                lot_lt++;
            } else {
                win_lt++;
            }
        }
        answer[0] = Grade(count + zero_count);
        answer[1] = Grade(count);

        return answer;
    }

    private static int Grade(int n) {
        switch (n) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] lottos = new int[6];
        int[] win_nums = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            lottos[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            win_nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : solution(lottos, win_nums)) {
            System.out.print(x + " ");
        }
    }
}
