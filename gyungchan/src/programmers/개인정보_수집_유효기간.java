package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 개인정보_수집_유효기간 {
    public static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] Today = getToday(today);

        // 약관 종류별 유효기간(M) 설정
        HashMap<Character, Integer> months = setValidity(terms);

        int index = 1;
        for (String privacy : privacies) {
            String[] str = privacy.split(" ");

            // 약관 종류별 유효기간(M) 가져오기
            int x = getValidity(months, str);

            String[] day = str[0].split("[.]");

            // 개인정보 보관 가능 날짜
            int[] deadLine = setDeadLine(x, day);

            checkValidity(answer, Today, index, deadLine);
            index++;
        }

        return answer;
    }

    private static int[] getToday(String today) {
        int[] int_today = new int[3];
        String[] str_today = today.split("[.]");
        for (int i = 0; i < 3; i++) {
            int_today[i] = Integer.parseInt(str_today[i]);
        }
        return int_today;
    }

    private static HashMap<Character, Integer> setValidity(String[] terms) {
        HashMap<Character, Integer> months = new HashMap<>();
        for (String term : terms) {
            String[] str = term.split(" ");
            months.put(str[0].charAt(0), Integer.parseInt(str[1]));
        }
        return months;
    }

    private static int getValidity(HashMap<Character, Integer> months, String[] str) {
        int M = months.get(str[1].charAt(0));
        return M;
    }

    private static int[] setDeadLine(int x, String[] day) {
        /**
         * deadLine[0] = YYYY
         * deadLine[1] = MM
         * deadLine[2] = DD
         */
        int[] deadLine = new int[3];
        deadLine[0] = Integer.parseInt(day[0]);

        deadLine[1] = Integer.parseInt(day[1]) + x;
        int plusY = 0;
        while (deadLine[1] > 12) {
            deadLine[1] -= 12;
            plusY++;
        }
        deadLine[0] += plusY;

        deadLine[2] = Integer.parseInt(day[2]) - 1;
        if (deadLine[2] <= 0) {
            deadLine[2] = 28;
            deadLine[1] -= 1;
            if (deadLine[1] == 0) {
                deadLine[1] = 12;
                deadLine[0]--;
            }
        }
        return deadLine;
    }

    private static void checkValidity(ArrayList<Integer> answer, int[] int_today, int index, int[] deadLine) {
        for (int i = 0; i < 3; i++) {
            if (int_today[i] == deadLine[i]) {
                continue;
            } else if (int_today[i] > deadLine[i]) {
                answer.add(index);
                break;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String today = "2022.01.01";
        String[] terms = {"A 100", "B 99", "C 3", "D 50"};
        String[] privacies = {"2020.01.01 A", "2021.12.28 B", "2008.10.01 C", "2022.02.20 D"};

        for (int x : solution(today, terms, privacies)) {
            System.out.print(x + " ");
        }
    }
}
