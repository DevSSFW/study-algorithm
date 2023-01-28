package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신규_아이디_추천 {

    public static String solution(String new_id) {
        String answer = new_id;
        answer = make_lowerCase(answer);
        answer = make_cleanId(answer);
        answer = make_notDuplicatedId(answer);
        answer = make_noDot(answer);
        answer = make_notNull(answer);
        answer = make_short(answer);
        answer = make_long(answer);

        return answer;
    }

    private static String make_lowerCase(String newId) {
        return newId.toLowerCase();
    }

    private static String make_cleanId(String newId) {
        newId = newId.replace(" ", "");
        return newId.replaceAll("[^-_.a-z0-9]", "");
    }

    private static String make_notDuplicatedId(String newId) {
        while (newId.contains("..")) {
            newId = newId.replace("..", ".");
        }
        return newId;
    }

    private static String make_noDot(String newId) {
        return newId.replaceAll("^[.]|[.]$", "");
    }

    private static String make_notNull(String newId) {
        if (newId.equals("")) {
            newId = "a";
        }
        return newId;
    }

    private static String make_short(String newId) {
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = make_noDot(newId);
        }
        return newId;
    }

    private static String make_long(String newId) {
        int n = newId.length();
        if (n < 3) {
            char c = newId.charAt(n-1);
            while (n < 3) {
                newId += c;
                n++;
            }
        }
        return newId;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
}
