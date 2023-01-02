package programmers;

public class 숫자_문자열과_영단어 {

    public static int solution(String s) {
        int answer = 0;
        String[] str = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(str[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }
}
