package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
    static int[] box;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            box = new int[100];

            for (int i = 0; i < 100; i++) {
                box[i] = sc.nextInt();
            }
            /**
             * if(box[0]>box[1])
             * int tmp = box[0]
             * box[0] = box[1]
             * box[1] = tmp
             */

            for (int i = 0; i < N; i++) {
                Arrays.sort(box);
                if (box[99] - box[0] == 0) {
                    break;
                }
                box[99]--;
                box[0]++;
            }
            System.out.println("#" + test_case + " " + (Math.max(box[99], box[98]) - Math.min(box[0], box[1])));
        }
    }
}
