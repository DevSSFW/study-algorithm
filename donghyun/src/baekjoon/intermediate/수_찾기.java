package baekjoon.intermediate;

import java.util.*;

/**
 * 범위를 절반으로 줄여나가는 이분탐색의 탐색법 학습
 * 이분 탐색은 O(log N)에 동작하기 때문에 N이 커지면 커질수록
 * 선형탐색법과 큰 차이가 난다.
 */

public class 수_찾기 {
    static int N, M;
    static int[] arr;
//    static int[] arr2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        M = sc.nextInt();
        while (M-- > 0) {
            int t = sc.nextInt();
            System.out.println(binarySearch(t));
        }
    }
    public static int binarySearch(int target) {
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else return 1;
        }
        return 0;
    }
}
