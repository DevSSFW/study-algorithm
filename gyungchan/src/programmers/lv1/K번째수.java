package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;

public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer>[] lists = new ArrayList[commands.length];
        for (int i = 0; i < commands.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < commands.length; j++) {
                if (commands[j][1] < i + 1) {
                    continue;
                }
                if (commands[j][0] <= i + 1) {
                    lists[j].add(array[i]);
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            Collections.sort(lists[i]);
            int x = commands[i][2];
            for (int j = 0; j < lists[i].size(); j++) {
                if (x == j + 1) {
                    answer[i] = lists[i].get(j);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        for (int x : solution(array, commands)) {
            System.out.print(x + " ");
        }
    }
}
