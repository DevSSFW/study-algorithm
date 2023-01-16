package programmers;

import java.util.ArrayList;

public class 다트게임 {
    public static int solution(String dartResult) {
        int answer = 0;
        char[] result = dartResult.toCharArray();
        ArrayList<Integer> scores = new ArrayList<>();
        int score = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = result[i];
            if (Character.isDigit(c)) {
                if (i - 1 >= 0 && result[i] == '0' && result[i - 1] == '1') {
                    score = 10;
                } else {
                    score = result[i] - '0';
                }
            } else if (Character.isAlphabetic(c)) {
                switch (c) {
                    case 'S':
                        scores.add(score);
                        break;
                    case 'D':
                        score = score * score;
                        scores.add(score);
                        break;
                    case 'T':
                        score = score * score * score;
                        scores.add(score);
                        break;
                }
            } else {
                switch (c) {
                    case '*':
                        scores.set(scores.size() - 1, scores.get(scores.size() - 1) * 2);
                        if (scores.size() >= 2) {
                            scores.set(scores.size() - 2, scores.get(scores.size() - 2) * 2);
                        }
                        break;
                    case '#':
                        scores.set(scores.size() - 1, scores.get(scores.size() - 1) * -1);
                        break;
                }
            }
        }

        for (int x : scores) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        String dartResult = "1D2S3T*";

        System.out.println(solution(dartResult));
    }
}
