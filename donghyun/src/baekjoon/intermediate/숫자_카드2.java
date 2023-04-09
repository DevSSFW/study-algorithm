package baekjoon.intermediate;

import java.io.*;
import java.util.*;

/**
 * 이진탐색 -> 중복된 카드 고려하여 카드 개수 반환
 * 기존 target 값이 있는지 없는지나 값 자체를 반환하는 유형이 아닌
 *  lowerBound, upperBound를 통해 target의 개수를 구함
 *  인덱스 범위에 유념
 */
public class 숫자_카드2 {
    static int N, M;
    static int[] arr;
    static int[] targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        //2 3 3 6 7 ...
        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int answer = upperBound(targets[i]) - lowerBound(targets[i]);
            sb.append(answer).append(" ");
        }
        System.out.println(sb);

    }

    public static int lowerBound(int target) {
        int left = 0;
        int right = N; //
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int upperBound(int target) {
        int left = 0;
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
