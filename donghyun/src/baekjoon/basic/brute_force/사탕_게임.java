package baekjoon.basic.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Array;
import java.util.Arrays;

public class 사탕_게임 {
    /**
     * NxN 크기에 사탕을 채운다. 사탕의 색은 모두 같지 않을 수 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. ... 먹을 수 있는 사탕의 최대 개수 구하기
     * input -> 보드 크기 N (3<=N<=50)
     * ex) N=3 -> (인접한 두 칸
     * CCP
     * CCP
     * PPC
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N = 3
        String[][] arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; i < j; j++) {

            }
        }
    }
}
