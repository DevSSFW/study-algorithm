package programmers.lv1_2;

import java.util.Arrays;

public class 최댓값과_최솟값 {
    public static String solution(String s) {
        String[] a = s.split(" ");
        int[] arr = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(arr);

        int max = arr[arr.length - 1];
        int min = arr[0];

        return min + " " + max;
    }

}
