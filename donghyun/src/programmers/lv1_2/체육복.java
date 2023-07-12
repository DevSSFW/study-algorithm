package programmers.lv1_2;

import java.util.Arrays;
import java.util.Comparator;

public class 체육복 {
    public static void solution() {
        int[][] arr1 = new int[2][2];
//        Arrays.sort(arr1, new Comparator<int[]>() {
            /*@Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) { 5 4
                    return -1;
                } else if (o1[0] < o2[0]) { 4 5 -> 5 4
                    return 1;
                } else {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] < o2[1]) {
                        return -1;

                    } else {
                        return 0;
                    }
                }
            }
        });*/
        // 1번 인덱스 오름차순, 0번 인덱스 내림차순
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{3};
        /** 1번 잃어버린 사람, 빌려줄 수 있는 사람 정렬**/
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;


        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i]) {
                    reserve[j] = -9999;
                    lost[i] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] > 0 && lost[i] > 0) {
                    if (Math.abs(reserve[j] - lost[i]) == 1) {
                        reserve[j] = -9999;
                        lost[i] = 0;
                        break;
                    }
                }
            }
        }
        for (int check : lost) {
            if (check == 0) answer++;
        }
        System.out.println(answer);
    }


}
