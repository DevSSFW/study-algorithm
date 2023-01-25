package baekjoon.Intro.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p>B_1267</p>
 */
public class 핸드폰_요금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int Y = 0; //30초마다 10원씩 증가
        int M = 0; //60초마다 15원씩 증가
        for (int i = 0; i < N; i++) {
            Y += ((arr[i] / 30) + 1) * 10;
            M += ((arr[i] / 60) + 1) * 15;
        }

        if (Y > M) {
            sb.append("M ").append(M);
            System.out.println(sb);
        } else if (Y < M) {
            sb.append("Y ").append(Y);
            System.out.println(sb);
        } else if (Y == M) {
            sb.append("Y M ").append(Y);
            System.out.println(sb);
        }
        br.close();
    }
}
