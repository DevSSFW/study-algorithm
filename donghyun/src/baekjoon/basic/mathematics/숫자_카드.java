package baekjoon.basic.mathematics;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * B_10815
 * 정수 하나가 적혀있는 숫자 카드. 카드를 N개 가진다.
 * 정수 M이 주어질때, 이 수를 가지고 있는지 아닌지를 판별한다.
 */
public class 숫자_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numberCards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numberCards[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(numberCards);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(numberCards, N, temp) + " ");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * <p>반복문으로 구현한 이진 탐색</p>
     * @param card 카드 배열
     * @param N 카드 개수
     * @param search 찾으려는 타겟 값
     * @return 타겟 값
     */
    public static int binarySearch(int[] card, int N, int search) {
        int first = 0;
        int last = N - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;
            if (card[mid] == search) {
                return 1;
            }
            if (card[mid] < search) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return 0;
    }
}
