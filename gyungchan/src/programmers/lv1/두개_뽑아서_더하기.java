package programmers.lv1;

import java.util.TreeSet;

public class 두개_뽑아서_더하기 {

    public static int[] solution(int[] numbers) {
        TreeSet<Integer> T = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                T.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[T.size()];
        int i = 0;
        for (int x : T) {
            answer[i++] = x;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        for (int x : solution(numbers)) {
            System.out.print(x + " ");
        }
    }
}
