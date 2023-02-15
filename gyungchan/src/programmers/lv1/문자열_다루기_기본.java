package programmers.lv1;

public class 문자열_다루기_기본 {
    public static boolean solution(String s) {
        boolean answer = true;
        if(s.length()==6 || s.length()==4) {
            String tmp = s.replaceAll("[^0-9]", "");
            if(tmp.length() != s.length()) return false;
        } else return false;

        return answer;
    }

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(solution(s));
    }
}
