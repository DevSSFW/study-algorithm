package baekjoon.intermediate;

import java.util.*;
import java.io.*;

public class 부분합 {

    static int N, S;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
//    static int start, end;

    public static void main(String[] args) throws Exception {
        // 10000이하 자연수로 이루어진 길이 N의 수열
        // 이 수열에서 연속된 수들의 부분합중 에 합이 S 이상
        // 가장 짧은 것의 *길이*를 구하라
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(twoPointer());

    }

    public static int twoPointer() {
        int start = 0;
        int end = 0;
        int total = arr[0];

        while (start <= end && end < N) {
            if (total >= S) {
                total -= arr[start];
                answer = Math.min(answer, arr[end] - arr[start] + 1);
                start++;
                continue;
            } else { //arr[end]+arr[start] < S
                end++;
                total += arr[end];
            }
        }
        return answer;
    }
}
