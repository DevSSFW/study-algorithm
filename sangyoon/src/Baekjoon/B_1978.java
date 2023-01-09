package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            for(int p = 2; p <= num; p++) {
                if(p == num) {
                    cnt++;
                }
                if(num % p == 0) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
