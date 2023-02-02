package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gravity {
    static int width;
    static int height;

    static int maxFallen;
    static int countEmpty;
    static int[][] room = new int[100][100];
    static int[] boxTop = new int[100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_case; test_case++) {

            width = Integer.parseInt(br.readLine()); //좌우 길이 ex) 10
            height = Integer.parseInt(br.readLine()); //상하 길이 ex) 20
            maxFallen = 0;

            for (int i = 0; i < width; i++) {
                boxTop[i] = Integer.parseInt(br.readLine()); //박스 높이 ex) 10개의 높이를 받는다.

                for (int j = 0; j < boxTop[i]; j++) {
                    room[i][j] = 1; // (0,0) 위에서부터 박스 유무 할당
                }
            }
            //박스 90도 회전
            for (int i = 0; i < width; i++) { // 10개의 박스 개수 만큼
                if (boxTop[i] > 0) { // 박스 높이가 0보다 크면
                    countEmpty = 0; // 빈 공간 개수는 0이다.

                    for (int j = i + 1; j < width; j++) { // 박스 1부터 10까지
                        if (room[j][boxTop[i] - 1] == 0) { //
                            countEmpty++;
                        }
                    }

                    if (countEmpty > maxFallen) {
                        maxFallen = countEmpty;
                    }
                }
            }

            System.out.println(maxFallen);
        }
    }
}
