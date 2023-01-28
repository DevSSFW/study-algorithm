package programmers.lv1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 모의고사 {
    public static ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] person = new int[4];
        Queue<Integer> one = new LinkedList<>();
        Queue<Integer> two = new LinkedList<>();
        Queue<Integer> three = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            one.offer(i);
        }

        int[] two_answer = {1, 3, 4, 5};
        for (int x : two_answer) {
            two.offer(2);
            two.offer(x);
        }

        int[] three_answer = {3, 1, 2, 4, 5};
        for (int y : three_answer) {
            three.offer(y);
            three.offer(y);
        }

        for (int a : answers) {
            int one_num = one.poll();
            one.offer(one_num);
            int two_num = two.poll();
            two.offer(two_num);
            int three_num = three.poll();
            three.offer(three_num);

            if (one_num == a) person[1]++;
            if (two_num == a) person[2]++;
            if (three_num == a) person[3]++;
        }

        int max = 0;
        for (int i = 1; i <= 3; i++) {
            if (person[i] > max) {
                max = person[i];
                answer.clear();
                answer.add(i);
            } else if (person[i] == max) {
                answer.add(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        for (int x : solution(answers)) {
            System.out.print(x + " ");
        }
    }
}
