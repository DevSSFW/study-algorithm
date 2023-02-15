package programmers.lv1;

public class 수박수박 {
    public static String solution(int n) {
        String answer = "";
        int count = n / 2;
        for (int i = 0; i < count; i++) {
            answer += "수박";
        }
        if (n % 2 != 0) {
            answer += "수";
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
}
