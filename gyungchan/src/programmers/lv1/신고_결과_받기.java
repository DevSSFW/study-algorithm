package programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 신고_결과_받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> hash = new HashSet<>();
        for (String x : report) {
            hash.add(x);
        }
        String[] tmp = new String[hash.size()];
        int lt = 0;
        for (String x : hash) {
            tmp[lt++] = x;
        }
        HashMap<String, Integer> map = new HashMap<>();
        String[][] report_count = new String[hash.size()][2];
        for (int i = 0; i < hash.size(); i++) {
            String[] s = tmp[i].split(" ");
            for (int j = 0; j < 2; j++) {
                report_count[i][j] = s[j];
            }
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) >= k) {
                for (int i = 0; i < hash.size(); i++) {
                    if (report_count[i][1].equals(s)) {
                        list.add(report_count[i][0]);
                    }
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            for (String name : list) {
                if (id_list[i].equals(name)) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;
        for (int x : solution(id_list, report, k)) {
            System.out.print(x + " ");
        }
    }
}