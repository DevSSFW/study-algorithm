package baekjoon.intro.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕_게임 {
    public static int N;
    public static char[][] board;
    public static int max = 0;

    /**
     * NxN 크기에 사탕을 채운다. 사탕의 색은 모두 같지 않을 수 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. ... 먹을 수 있는 사탕의 최대 개수 구하기
     * input -> 보드 크기 N (3<=N<=50)
     * ex) N=3 -> (인접한 두 칸)
     * CCP
     * CCP
     * PPC
     */
    private static void swap(int y1, int x1, int y2, int x2) { // 열은 열끼리 가로 스왑 가능 ex) (2,1) -> (2,2) , 행은 행끼리 세로 스왑 ex) (1,2) -> (0,2)
        char temp = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = temp;
    }

    private static int checkBoard(int y1, int x1, int y2, int x2) {
        int currentCandy = 1;

        for (int i = 1; i < N; i++) {
            if (board[y1][i] == board[y1][i - 1]) { // 가로 방향 비교하기(왼,오) -> 가로 값과 같을 경우 current ++
                currentCandy++;
            } else {
                currentCandy = 1;
            }
            max = Math.max(currentCandy, max); //두 인자 값 중 큰 값을 max로 리턴한다.
        }

        currentCandy = 1;
        for (int i = 1; i < N; i++) {
            if (board[y2][i] == board[y2][i - 1]) { // 가로 방향 비교하기 (왼, 오) -> 가로 값과 같을 경우 current ++
                currentCandy++;
            } else {
                currentCandy = 1;
            }
            max = Math.max(currentCandy, max);
        }

        currentCandy = 1;
        for (int i = 1; i < N; i++) {
            if (board[i][x1] == board[i - 1][x1]) { // 세로 방향 비교하기(위,아래)
                currentCandy++;
            } else {
                max = Math.max(currentCandy, max);
                currentCandy = 1;
            }
            max = Math.max(currentCandy, max);
        }

        currentCandy = 1;
        for (int i = 1; i < N; i++) {
            if (board[i][x2] == board[i - 1][x2]) {
                currentCandy++;
            } else {
                max = Math.max(currentCandy, max);
                currentCandy = 1;
            }
            max = Math.max(currentCandy, max);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N = 3
        board = new char[N][N]; // arr = 3 x 3

        for (int index = 0; index < N; index++) {
            board[index] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < N - 1) {   // () -> 아래측 인접한 사탕과 swap, 비교 후 다시 swap
                    swap(i, j, i + 1, j);
                    max = Math.max(max, checkBoard(i, j, i + 1, j));
                    swap(i, j, i + 1, j);
                }
                if (j < N - 1) { // () -> 우측 인접 사탕과 swap 해보고 다시 swap
                    swap(i, j, i, j + 1);
                    max = Math.max(max, checkBoard(i, j, i, j + 1));
                    swap(i, j, i, j + 1);
                }
            }
        }
        System.out.println(String.valueOf(max));

        br.close();
    }
}
