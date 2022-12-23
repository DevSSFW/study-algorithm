package baekjoon.basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <p>B_1475</p>
 */
public class 방_번호 {
    private static int SIX = 6;
    private static int NINE = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); //8888
        checkRoomNumber(s);
        br.close();
    }

    private static void checkRoomNumber(String s) {
        int[] array = new int[10];

        for (char c : s.toCharArray()) {
            int number = c - '0'; // 1(49) - 0(48) = (int)1
            if (number == NINE) {
                number = SIX;
            }
            array[number]++;
        }
        array[SIX] = array[SIX] / 2 + array[SIX] % 2; //9를 6으로 몰아서 합산했기 때문에, 1세트(6,9) 해당 2로 나눈다. 홀수일 경우 +1을 위해 나머지 합산
        Arrays.sort(array);
        System.out.println(array[NINE]);
    }
}
