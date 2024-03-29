package baekjoon.intermediate;

import java.util.*;
import java.io.*;

public class 부분합 {

    static int N, S;
    static int[] arr;

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
        System.out.println(twoPointer());
    }

    public static int twoPointer() {
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = arr[0];

        while (start <= end && end < N) {
            if (sum >= S) { //합이 S보다 같거나 클 경우를 체크하여
                answer = Math.min(answer, end - start + 1); //길이(답)를 업데이트하고
                sum -= arr[start]; //합에서 start 포인터에 해당하는 값을 빼준다.
                start++;
            } else {
                end++;
                if (end < N) {
                    sum += arr[end];
                }
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
