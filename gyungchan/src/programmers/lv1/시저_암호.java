package programmers.lv1;

public class 시저_암호 {
    public static String solution(String s, int n) {
        String answer = "";
        char[] tmp = s.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if (Character.isAlphabetic(tmp[i])) {
                if (Character.isUpperCase(tmp[i])) {
                    tmp[i] = (char) (tmp[i] + n);

                    if (!Character.isUpperCase(tmp[i]) || !Character.isAlphabetic(tmp[i])) {
                        tmp[i] = (char) (tmp[i] - 26);
                    }
                } else {
                    tmp[i] = (char) (tmp[i] + n);

                    if (!Character.isAlphabetic(tmp[i])) {
                        tmp[i] = (char) (tmp[i] - 26);
                    }
                }
            }
        }
        answer = String.valueOf(tmp);
        return answer;
    }

    public static void main(String[] args) {
        String s = "Z";
        int n = 25;
        System.out.println(solution(s, n));
    }
}
