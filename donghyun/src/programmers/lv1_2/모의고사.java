package programmers.lv1_2;

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int aCounter = 0;
        int bCounter = 0;
        int cCounter = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer1[i % 5]) aCounter++;
            if (answers[i] == answer2[i % 8]) bCounter++;
            if (answers[i] == answer3[i % 10]) cCounter++;
        }

        int max = Math.max(aCounter, Math.max(bCounter, cCounter));
        List<Integer> list = new ArrayList<>();

        if (max == aCounter) {
            list.add(1);
        }
        if (max == bCounter) {
            list.add(2);
        }
        if (max == cCounter) {
            list.add(3);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
