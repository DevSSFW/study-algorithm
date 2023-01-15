package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> store = new HashMap<>();
        for (String name : participant) {
            store.put(name, store.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            store.put(name, store.get(name) - 1);
        }

        for (String name : store.keySet()) {
            if (store.get(name) != 0) {
                answer = name;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }
}
