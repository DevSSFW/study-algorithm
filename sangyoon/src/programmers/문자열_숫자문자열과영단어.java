package programmers;

import java.io.IOException;

public class 문자열_숫자문자열과영단어 {
    public static void main(String[] args) throws IOException {
        String string = "one4seveneight";

        문자열_숫자문자열과영단어 s = new 문자열_숫자문자열과영단어();
        System.out.println(s.solution(string));
    }

    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replace(arr[i], Integer.toString(i));
        }

        int answer = Integer.parseInt(s);
        return answer;
    }
}
