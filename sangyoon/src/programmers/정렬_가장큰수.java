package programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class 정렬_가장큰수 {
    public static void main(String[] args) throws IOException {
        int[] numbers = {6, 10, 2};

        정렬_가장큰수 s = new 정렬_가장큰수();
        System.out.println(s.solution(numbers));
    }

    public String solution(int[] numbers) {

        String[] temp = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (temp[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();

        for(String s: temp) answer.append(s);

        return answer.toString();
    }
}
