package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class 제일_작은_수_제거하기 {
    public static ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length == 1) {
            list.add(-1);
        } else {
            int min = Arrays.stream(arr).min().getAsInt();
            for (int x : arr) {
                if (x != min) {
                    list.add(x);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};

        for (int x : solution(arr)) {
            System.out.println(x + " ");
        }
    }
}
