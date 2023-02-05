package swea;

import java.io.*;
import java.util.Scanner;

public class BabyGin {
    static int card;
    static int[] cards = new int[10];
    static int triplet;
    static int run;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            card = Integer.parseInt(br.readLine());

            for (int i = 0; i < 6; i++) {
                cards[(card % 10)]++;
                card /= 10;
            }
            for (int i = 0; i < 10; i++) {
                if (cards[i] >= 3) {
                    cards[i] -= 3;
                    triplet++;
                    i--;
                }
            }
        }
    }


    /**
     * 거스름돈 (그리디 예제)

     static int money;

     public static void main(String[] args) {
     int[] coins = {500, 250, 100, 50, 10};
     int[] count = new int[5];
     int i = 0;

     Scanner sc = new Scanner(System.in);
     money = sc.nextInt();

     while (money != 0) {
     if (money < 0) {
     count[i]--;
     money += coins[i++];
     } else {
     count[i]++;
     money -= coins[i];
     }
     }
     for (i = 0; i < 5; i++) {
     System.out.println(coins[i] + ":" + count[i]);
     }
     }
     */

}
