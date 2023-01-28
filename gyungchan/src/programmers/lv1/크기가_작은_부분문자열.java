package programmers.lv1;

public class 크기가_작은_부분문자열 {

    public static int solution(String t, String p) {
        int answer = 0;
        String tmp = "";
        for (int i = 0; i < p.length()-1; i++) {
            tmp += t.charAt(i);
        }

        for (int i = p.length()-1; i < t.length(); i++) {
            tmp += t.charAt(i);
            if (p.equals(tmp)) {
                answer++;
            } else {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) < tmp.charAt(j)) {
                        break;
                    } else if (p.charAt(j) > tmp.charAt(j)) {
                        answer++;
                        break;
                    }
                }
            }
            tmp = tmp.substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String t = "10203";
        String p = "15";

        System.out.println(solution(t, p));
    }
}
